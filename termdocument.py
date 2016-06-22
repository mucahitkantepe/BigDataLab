from pymongo import MongoClient
from sklearn.feature_extraction.text import CountVectorizer
import numpy as np

client = MongoClient()
db = client.twitter
timeline = db.timeline

query ={}
projection = {'text' : 1, '_id' : 0,'user.id' : 1}


tweetTextList = []
tweetDictList=[]

def find(query):

    try:
        cursor = timeline.find({},projection)

    except Exception as e:
        print
        "Unexpected error:", type(e), e

    for doc in cursor:
        tweetDict = {}
        tweetDict['id'] = doc['user']['id']
        tweetDict['text'] = doc['text']
        tweetDictList.append(tweetDict)
        tweetTextList.append(tweetDict['text'])


find(query)

# print(tweetDictList[0]['id'])


merged = {}

for tweet in  tweetDictList:
    if tweet['id'] not in merged:
        merged['id'] = tweet['id']



cv = CountVectorizer()

X = cv.fit_transform(tweetTextList) # tüm tweetler textListte.
terms = np.array(cv.get_feature_names())
docs = np.asarray(X)# X.sum(axis=0) yaparsan 0'ları siler.
document_term_tuple = np.asarray([docs,terms]).tolist()
print(document_term_tuple)