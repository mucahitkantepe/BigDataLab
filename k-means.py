from pymongo import MongoClient

from twitter_miner import show_clustering_summary, standardizer

connection = MongoClient()
db = connection.mydb
users = db.things


try:
    projection = {'_id': 0, 'TwitterId': 0, 'Name': 0, 'Url': 0, 'CreatedDate': 0,
                  'date_last_x_keyword_tw': 0, 'date_last_tweet': 0}

    cursor = users.find({}, projection)

except Exception as e:
    print("Unexpected error:", type(e), e)

userList = []

for user in cursor:
    standardizer(user)
    userList.append(user)

show_clustering_summary(userList, 3)

# print("cluster centroids with 4 clusters")
# k_means4 = cluster.KMeans(n_clusters=4).fit(normalizedcentroid)
# #print(k_means4.cluster_centers_)


##################################################################
# Visualize the results on PCA-reduced data

# print("Graphical representation with 3 clusters")
#
# reduced_data = PCA(n_components=2).fit_transform(normalizedcentroid)
# k_means3.fit(reduced_data)
#
# # Step size of the mesh. Decrease to increase the quality of the VQ.
# h = .02  # point in the mesh [x_min, m_max]x[y_min, y_max].
#
# # Plot the decision boundary. For that, we will assign a color to each
# x_min, x_max = reduced_data[:, 0].min() - 1, reduced_data[:, 0].max() + 1
# y_min, y_max = reduced_data[:, 1].min() - 1, reduced_data[:, 1].max() + 1
# xx, yy = np.meshgrid(np.arange(x_min, x_max, h), np.arange(y_min, y_max, h))
#
# # Obtain labels for each point in mesh. Use last trained model.
# Z = k_means3.predict(np.c_[xx.ravel(), yy.ravel()])
#
# # Put the result into a color plot
# Z = Z.reshape(xx.shape)
# plt.figure(1)
# plt.clf()
# plt.imshow(Z, interpolation='nearest',
#            extent=(xx.min(), xx.max(), yy.min(), yy.max()),
#            cmap=plt.cm.Paired,
#            aspect='auto', origin='lower')
#
# plt.plot(reduced_data[:, 0], reduced_data[:, 1], 'k.', markersize=2)
# # Plot the centroids as a white X
# centroids = k_means3.cluster_centers_
# plt.scatter(centroids[:, 0], centroids[:, 1],
#             marker='x', s=169, linewidths=3,
#             color='w', zorder=10)
# plt.title('K-means clustering on the digits dataset (PCA-reduced data)\n'
#           'Centroids are marked with white cross')
# plt.xlim(x_min, x_max)
# plt.ylim(y_min, y_max)
# plt.xticks(())
# plt.yticks(())
# plt.show()
