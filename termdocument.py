from pymongo import MongoClient
from sklearn.feature_extraction.text import TfidfVectorizer
import numpy as np

client = MongoClient()
db = client.twitter
timeline = db.timeline

query ={}
projection = {'text' : 1, '_id' : 0,'user.id' : 1}

tweetDictList=[]

def find(query):

    try:
        cursor = timeline.find(query,projection)

    except Exception as e:
        print
        "Unexpected error:", type(e), e

    for doc in cursor:
        tweetDict = {}
        tweetDict['id'] = doc['user']['id']
        tweetDict['text'] = doc['text']
        tweetDictList.append(tweetDict)
find(query)

# tweet texts merge by user
def find_index(dicts, key, value):
    class Null: pass
    for i, d in enumerate(dicts):
        if d.get(key, Null) == value:
            return i
    else:
        return -1
merged = []

for tweet in  tweetDictList:
    tweetDict = {}
    index1 = find_index(tweetDictList,'id',tweet['id'])
    index2 = find_index(merged,'id',tweet['id'])
    #if in  list
    if index2 >= 0:
        merged[index2]['text'] += " " + tweet['text']
    #if not in list
    else:
        tweetDict['id'] = tweet['id']
        tweetDict['text'] = tweet['text']
        merged.append(tweetDict)
#print(merged)

vect = TfidfVectorizer(min_df=1)
tfidf = vect.fit_transform([d['text'] for d in merged])
terms = np.array(vect.get_feature_names())
docs = np.asarray(tfidf)
dtm = np.asarray([docs,terms]).tolist()
similarityMatrix = (tfidf * tfidf.T).A
sumdocs = np.sum(docs,axis=0)
# meandocs = np.mean(docs,axis=0)
# stddocs = np.std(docs,axis=0)
np.savetxt("foo.csv", similarityMatrix, delimiter=",")

vect = TfidfVectorizer(min_df=1)
X = vect.fit_transform([d['text'] for d in tweetDictList])
terms = np.array(vect.get_feature_names())
docs = np.asarray(X)
dtm = np.asarray([docs,terms]).tolist()
sumdocs = np.sum(docs,axis=0)
# meandocs = np.mean(docs, axis=0)
# stddocs = np.std(docs, axis=0)