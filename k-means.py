import matplotlib.pyplot as plt
import numpy as np
from pymongo import MongoClient
from sklearn import cluster
from sklearn import preprocessing
from sklearn.decomposition import PCA
from sklearn.feature_extraction.text import TfidfVectorizer

connection = MongoClient()
db = connection.mydb
users = db.things


def boolkeystoint(doc):
    for key, value in doc.items():
        if doc[key] == "True":
            doc[key] = 1
        elif doc[key] == "False":
            doc[key] = 0


try:
    projection = {'_id': 0, 'TwitterId': 0, 'Name': 0, 'Url': 0, 'CreatedDate': 0,
                  'date_last_x_keyword_tw': 0, 'date_last_tweet': 0, 'Description': 0}

    cursor = users.find({}, projection)

except Exception as e:
    print("Unexpected error:", type(e), e)

userList = []

for user in cursor:
    boolkeystoint(user)
    lang = user['Language']
    if lang != 'tr' or lang != "Tr" or lang != "Turkish" or lang != "turkish":
        user['Language'] = 0
    else:
        user['Language'] = 1
    userList.append(user)

vect = TfidfVectorizer(min_df=1)
textTfidf = vect.fit_transform([user['x_tweets'] for user in userList])
keywordTfidf = vect.fit_transform([user['x_keywords'] for user in userList])

centroidList = []
for i, row in enumerate(userList):
    # userList[i]['textTfidf'] = textTfidf[i]
    # userList[i]['keywordTfidf'] = keywordTfidf[i]
    if 'name' in userList[i]:   del userList[i]['name']
    if 'x_tweets' in userList[i]:   del userList[i]['x_tweets']
    if 'x_keywords' in userList[i]:   del userList[i]['x_keywords']
    if 'ScreenName' in userList[i]:   del userList[i]['ScreenName']
    centroidList.append(list(userList[i].values()))
del userList

print("cluster centroids with 3 clusters")
normalizedcentroid = preprocessing.normalize(centroidList, norm='l2')
k_means3 = cluster.KMeans(n_clusters=3).fit(normalizedcentroid)
print(k_means3.cluster_centers_)

# for index, item in enumerate(kmeans.labels_):
#     if item != 0:   print(index, item)

print("cluster centroids with 4 clusters")

k_means4 = cluster.KMeans(n_clusters=4).fit(normalizedcentroid)
# for index, item in enumerate(k_means4.labels_):
#     if item != 0:   print(index, item)
print(k_means4.cluster_centers_)

##################################################################
# Visualize the results on PCA-reduced data

print("Graphical representation with 3 clusters")

reduced_data = PCA(n_components=2).fit_transform(normalizedcentroid)
k_means3.fit(reduced_data)

# Step size of the mesh. Decrease to increase the quality of the VQ.
h = .02  # point in the mesh [x_min, m_max]x[y_min, y_max].

# Plot the decision boundary. For that, we will assign a color to each
x_min, x_max = reduced_data[:, 0].min() - 1, reduced_data[:, 0].max() + 1
y_min, y_max = reduced_data[:, 1].min() - 1, reduced_data[:, 1].max() + 1
xx, yy = np.meshgrid(np.arange(x_min, x_max, h), np.arange(y_min, y_max, h))

# Obtain labels for each point in mesh. Use last trained model.
Z = k_means3.predict(np.c_[xx.ravel(), yy.ravel()])

# Put the result into a color plot
Z = Z.reshape(xx.shape)
plt.figure(1)
plt.clf()
plt.imshow(Z, interpolation='nearest',
           extent=(xx.min(), xx.max(), yy.min(), yy.max()),
           cmap=plt.cm.Paired,
           aspect='auto', origin='lower')

plt.plot(reduced_data[:, 0], reduced_data[:, 1], 'k.', markersize=2)
# Plot the centroids as a white X
centroids = k_means3.cluster_centers_
plt.scatter(centroids[:, 0], centroids[:, 1],
            marker='x', s=169, linewidths=3,
            color='w', zorder=10)
plt.title('K-means clustering on the digits dataset (PCA-reduced data)\n'
          'Centroids are marked with white cross')
plt.xlim(x_min, x_max)
plt.ylim(y_min, y_max)
plt.xticks(())
plt.yticks(())
plt.show()
