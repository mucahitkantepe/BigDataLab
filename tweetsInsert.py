import glob
import json

import pymongo
from pymongo import MongoClient

client = MongoClient()
db = client.university

filenames = glob.glob("/home/who/Desktop/universiteogrencileritimeline/*.txt")
db.tweets.create_index([("user.id", pymongo.ASCENDING)])
for filename in filenames:
    with open(filename) as f:
        for line in f:
            try:
                db.tweets.insert_one(json.loads(line))
            except:
                pass
