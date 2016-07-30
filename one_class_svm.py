from collections import OrderedDict

from pymongo import MongoClient
from sklearn import svm

from twitter_miner import normalized_centroid_list_extractor
from  twitter_miner import standardizer

client = MongoClient()
db = client.university
users = db.users

projection = {'_id': 0, 'geo_enabled': 1, 'day_of_week_active': 1, 'verified': 1, 'day_of_month_active': 1,
              'rate_geo': 1,
              'twitter_age': 1, 'rate_place': 1, 'protected': 1, 'rate_mention': 1, 'hour_active': 1, 'rate_mobile': 1,
              'listed_count': 1, 'rate_hashtags': 1, 'rate_Turkish': 1, 'rate_follow': 1, 'lang': 1,
              'followers_count': 1,
              'rate_url': 1, 'rate_fav': 1, 'default_profile': 1, 'rate_rt': 1, 'favourites_count': 1,
              'default_profile_image': 1, 'withheld': 1
              }

query = {}
studentList = []
centroidList = []

try:
    cursor = users.find(query, projection)

except Exception as e:
    print("Unexpected error:", type(e), e)

myorder = ['geo_enabled', 'day_of_week_active', 'verified', 'day_of_month_active', 'rate_geo',
           'twitter_age', 'rate_place', 'protected', 'rate_mention', 'hour_active', 'rate_mobile',
           'listed_count', 'rate_hashtags', 'rate_Turkish', 'rate_follow', 'lang', 'followers_count',
           'rate_url', 'rate_fav', 'default_profile', 'rate_rt', 'favourites_count',
           'default_profile_image', 'withheld'
           ]

for student in cursor:

    try:
        standardizer(student)
        user = OrderedDict((k, student[k]) for k in myorder)
        studentList.append(student)

    except:
        pass

student_normalized_centroid_list = normalized_centroid_list_extractor(studentList)

svm2 = svm.OneClassSVM(nu=0.1, kernel="rbf", gamma=0.1)
studentsSVM = svm2.fit(student_normalized_centroid_list)

other_projection = {'IsGeoEnabled': 1, 'day_of_week_active': 1, 'IsVerified': 1, 'day_of_month_active': 1,
                    'rate_gps': 1, 'twitter_age': 1, 'rate_place': 1, 'IsProtected'
                    : 1, 'rate_mentions': 1, 'hour_active': 1, 'rate_mobile': 1, 'ListedCount': 1, 'rate_hashtags': 1,
                    'rate_Turkish': 1, 'rate_follow': 1, 'Language': 1, 'FollowersCount': 1,
                    'rate_urls': 1, 'rate_fav_tw': 1, 'IsDefaultProfile': 1, 'rate_rt': 1, 'FavouritesCount': 1,
                    'IsDefaultProfileImage': 1, 'Withheld': 1}

other_order = ['IsGeoEnabled', 'day_of_week_active', 'IsVerified', 'day_of_month_active', 'rate_gps', 'twitter_age',
               'rate_place', 'IsProtected'
    , 'rate_mentions', 'hour_active', 'rate_mobile', 'ListedCount', 'rate_hashtags', 'rate_Turkish', 'rate_follow',
               'Language', 'FollowersCount',
               'rate_urls', 'rate_fav_tw', 'IsDefaultProfile', 'rate_rt', 'FavouritesCount', 'IsDefaultProfileImage',
               'Withheld']

db2 = client.mydb
things = db2.things

try:
    cursor = things.find(query, other_projection)

except Exception as e:
    print("Unexpected error:", type(e), e)

userList = []
for user in cursor:

    try:
        standardizer(user)
        user = OrderedDict((k, user[k]) for k in other_order)
        userList.append(user)
    except:
        pass

normalized_centroid_list = normalized_centroid_list_extractor(userList)
predictions = svm2.predict(normalized_centroid_list)

print(len([x for x in predictions if x == -1]))
