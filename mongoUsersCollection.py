from pymongo import MongoClient

client = MongoClient()
db = client.twitter

timeline = db.timeline
users = db.users
# adds unique index for user.id field. dropDubs makes rows unique for user.
users.ensure_index('user.id', unique=True, dropDubs=True)

projection = {'_id': 0, 'user.id': 1, 'user.screen_name': 1, 'user.name': 1, 'user.lang': 1, 'user.description': 1,
              'user.url': 1, 'user.created_at': 1, 'user.verified': 1, 'user.protected': 1, 'user.geo_enabled': 1,
              'user.default_profile': 1, 'user.default_profile_image': 1, 'user.statuses_count': 1,
              'user.favourites_count': 1,
              'user.followers_count': 1, 'user.friends_count': 1, 'user.listed_count': 1}


def find(query):
    try:
        cursor = timeline.find(query, projection)

    except Exception as e:
        print("Unexpected error:", type(e), e)

    for doc in cursor:
        try:
            users.insert_one(doc)
        except:
            pass


find({})
