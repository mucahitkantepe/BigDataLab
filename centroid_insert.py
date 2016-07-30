import numpy as np
from pymongo import MongoClient

# yourdate = dateutil.parser.parse(datestring)

client = MongoClient()
db = client.twitter
users = db.users
community = db.community

query = {}
projection = {'_id': 0, 'user.name': 0, 'user.screen_name': 0,
              'user.url': 0, 'user.description': 0, 'date_last_tweet': 0,
              'user.lang': 0, 'tdidf': 0, 'user.created_at': 0}


def boolkeystoint(doc):
    for key, value in doc.items():
        if type(doc[key]) == type(True):
            doc[key] = int(doc[key])
        if type(doc[key]) == type(doc):
            for key2, value in doc[key].items():
                if type(doc[key][key2]) == type(True):
                    doc[key][key2] = int(doc[key][key2])


def find(query):
    try:
        cursor = users.find(query, projection)

    except Exception as e:
        print("Unexpected error:", type(e), e)
    centroidlist = []
    for doc in cursor:
        centroid = []
        boolkeystoint(doc)
        for key, value in doc.items():
            if type(doc[key]) != type(doc) and type(doc[key]) != type([]):
                centroid.append(doc[key])
            elif type(doc[key]) != type([]):
                for key2, value in doc[key].items():
                    if key2 == 'id':
                        pass
                    else:
                        centroid.append(doc['user'][key2])
        print(centroid)
        centroidlist.append(centroid)
        users.update_one({'user.id': doc['user']['id']}, {'$set': {'centroid': centroid}})

    meancentroid = np.mean(np.array(centroidlist), axis=0)
    print(meancentroid)
    community.insert_one({'centroid': meancentroid.tolist()})


find(query)
