from pymongo import MongoClient

client = MongoClient()
db = client.twitter


db.timeline.find({geo : null})