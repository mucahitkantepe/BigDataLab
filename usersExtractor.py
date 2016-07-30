import os

from pymongo import MongoClient

client = MongoClient()
db = client.university

timeline = db.tweets
users = db.users
# adds unique index for id field. dropDubs makes rows unique for user.
users.ensure_index('id', unique=True, dropDubs=True)

projection = {'_id': 0, 'user.id': 1, 'user.screen_name': 1, 'user.name': 1, 'user.lang': 1, 'user.description': 1,
              'user.url': 1, 'user.created_at': 1, 'user.verified': 1, 'user.protected': 1, 'user.geo_enabled': 1,
              'user.default_profile': 1, 'user.default_profile_image': 1, 'user.statuses_count': 1,
              'user.favourites_count': 1, 'user.followers_count': 1, 'user.friends_count': 1, 'user.listed_count': 1}

query = {}

try:
    cursor = timeline.find(query, projection)

except Exception as e:
    print("Unexpected error:", type(e), e)

for doc in cursor:
    try:
        user = {"default_profile_image": doc['user']['default_profile_image'],
                "url": doc['user']['url'],
                "description": doc['user']['description'],
                "friends_count": doc['user']['friends_count'],
                "listed_count": doc['user']['listed_count'],
                "geo_enabled": doc['user']['geo_enabled'],
                "protected": doc['user']['protected'],
                "favourites_count": doc['user']['favourites_count'],
                "created_at": doc['user']['created_at'],
                "verified": doc['user']['verified'],
                "name": doc['user']['name'],
                "scree_name": doc['user']['screen_name'],
                "followers_count": doc['user']['followers_count'],
                "lang": doc['user']['lang'],
                "statuses_count": doc['user']['statuses_count'],
                "id": doc['user']['id'],
                "default_profile": doc['user']["default_profile"]}

        users.insert_one(user)

    except:
        pass

os.system("usersFieldCalculator.py")
