from collections import OrderedDict

from pymongo import MongoClient
from sklearn import cross_validation
from sklearn import preprocessing
from sklearn import svm, metrics

from twitter_miner import standardizer

connection = MongoClient()
db = connection.university
users = db.users

projection = {'_id': 0, 'verified': 1, 'lang': 1, 'friends_count': 1, 'followers_count': 1, 'favourites_count': 1,
              'id': 1, 'protected': 1, 'listed_count': 1, 'default_profile': 1, 'geo_enabled': 1,
              'withheld': 1, 'twitter_age': 1, 'rate_Turkish': 1, 'hour_active': 1, 'rate_follow': 1,
              'rate_hashtags': 1,
              'rate_place': 1, 'rate_mention': 1, 'day_of_week_active': 1, 'day_of_month_active': 1, 'rate_url': 1,
              'rate_mobile': 1, 'rate_geo': 1, 'rate_rt': 1, 'university_student': 1}

myOrder = ['verified', 'lang', 'friends_count', 'followers_count', 'favourites_count',
           'id', 'protected', 'listed_count', 'default_profile', 'geo_enabled',
           'withheld', 'twitter_age', 'rate_Turkish', 'hour_active', 'rate_follow', 'rate_hashtags',
           'rate_place', 'rate_mention', 'day_of_week_active', 'day_of_month_active', 'rate_url',
           'rate_mobile', 'rate_geo', 'rate_rt', 'university_student']
try:
    cursor = users.find({}, projection)
    userList = []

    for user in cursor:
        standardizer(user)
        user = OrderedDict((k, user[k]) for k in myOrder)
        userList.append(user)

    data = preprocessing.normalize(([list(user.values())[0:len(user) - 1] for user in userList]), norm='l2')
    target = [list(user.values())[-1] for user in userList]

    X_train, X_test, y_train, y_test = cross_validation.train_test_split(data, target, train_size=0.9, test_size=0.1)
    classifier = svm.SVC().fit(X_train, y_train)

    Y_pred = classifier.predict(X_test)
    scores = cross_validation.cross_val_score(classifier, data, target, cv=5)

    print("Accuracy: %0.2f (+/- %0.2f)" % (scores.mean(), scores.std() * 2))
    print("Score : ", classifier.score(X_test, y_test))
    print("Recall: %1.3f" % metrics.recall_score(y_test, Y_pred, average='macro'))
    # print("Precision score :",metrics.precision_score(y_test, Y_pred,average=None))


except Exception as e:
    print("Unexpected error:", type(e), e)
