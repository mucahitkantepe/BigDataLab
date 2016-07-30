import heapq

import numpy as np
from scipy.spatial import distance
from sklearn import cluster
from sklearn import preprocessing
from tabulate import tabulate


def bool_keys_to_int(doc):
    for key, value in doc.items():
        if doc[key] == "True" or doc[key] == True:
            doc[key] = 1
        elif doc[key] == "False" or doc[key] == False:
            doc[key] = 0


def lang_numericator(user):
    if 'lang' in user:
        lang = user['lang']
    else:
        lang = user['Language']

    if lang != "tr" or lang != "Tr" or lang != "Turkish" or lang != "turkish":
        if 'lang' in user:
            user['lang'] = 0
        else:
            user['Language'] = 0
    else:
        if 'lang' in user:
            user['lang'] = 1
        else:
            user['Language'] = 1


def standardizer(user):
    bool_keys_to_int(user)
    lang_numericator(user)


def normalized_centroid_list_extractor(userList):
    centroidList = []

    for i, user in enumerate(userList):
        filtered_user = {key: value for (key, value) in user.items()
                         if 'name' not in key and 'x_tweets' not in key and
                         'x_keywords' not in key and 'ScreenName' not in key and 'Description' not in key}
        centroidList.append(list(filtered_user.values()))

    return preprocessing.normalize(centroidList, norm='l2')


def print_cluster_features(features, kmeans):
    characteristics = []
    for f_index in range(len(kmeans.cluster_centers_[0])):
        max = (0, 0, 0)
        for c_index, cluster_centroid in enumerate(kmeans.cluster_centers_.tolist()):
            if cluster_centroid[f_index] > max[2]: max = (f_index, c_index, cluster_centroid[f_index])
        if max[2] != 0: characteristics.append(max)

    for c_index, cluster_centroid in enumerate(kmeans.cluster_centers_.tolist()):
        print("\nCharacteristics of Cluster {} : ".format(c_index), end="")
        for feature in enumerate(characteristics):
            if feature[1][1] == c_index:    print(features[feature[1][0]], end=", ")


def show_clustering_summary(userList, n_clusters):
    centroidList = []

    for i, user in enumerate(userList):
        filtered_user = {key: value for (key, value) in user.items()
                         if 'name' not in key and 'x_tweets' not in key and
                         'x_keywords' not in key and 'ScreenName' not in key and 'Description' not in key}
        centroidList.append(list(filtered_user.values()))

    normalized_centroids = preprocessing.normalize(centroidList, norm='l2')
    average_centroid = np.mean(np.array(normalized_centroids), axis=0)

    kmeans = cluster.KMeans(n_clusters=n_clusters).fit(normalized_centroids)

    features = list(filtered_user.keys())
    features_and_average_centroid = [list(a) for a in zip(*[features, average_centroid])]

    header = ["Features", "Average Centroid"]

    for i, cluster_centroid in enumerate(kmeans.cluster_centers_.tolist()):

        for j, elem in enumerate(cluster_centroid):
            features_and_average_centroid[j].append(cluster_centroid[j])

        header.append("Cluster {}".format(i))
        cluster_distances = []

        for user_centroid in normalized_centroids:
            cluster_distances.append(distance.euclidean(user_centroid, cluster_centroid))
        smallest = (heapq.nsmallest(400, range(len(cluster_distances)), cluster_distances.__getitem__))

        print("\nCluster {}".format(i))
        for index in smallest:
            print(userList[index]['ScreenName'], ": ", userList[index]['Description'])

    print(tabulate(features_and_average_centroid, headers=header))

    print_cluster_features(features, kmeans)


def print_n_samples(kmeans, userList, n):
    centroidList = []

    for i, user in enumerate(userList):
        filtered_user = {key: value for (key, value) in user.items()
                         if 'name' not in key and 'x_tweets' not in key and
                         'x_keywords' not in key and 'ScreenName' not in key and 'Description' not in key}
        centroidList.append(list(filtered_user.values()))

    normalized_centroids = preprocessing.normalize(centroidList, norm='l2')

    for i, cluster_centroid in enumerate(kmeans.cluster_centers_.tolist()):
        cluster_distances = []

        for user_centroid in normalized_centroids:
            cluster_distances.append(distance.euclidean(user_centroid, cluster_centroid))
        smallest = (heapq.nsmallest(n, range(len(cluster_distances)), cluster_distances.__getitem__))

        print("\nCluster {}".format(i))
        for index in smallest:
            print(userList[index]['ScreenName'], ": ", userList[index]['Description'])
