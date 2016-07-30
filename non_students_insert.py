from pymongo import MongoClient

nonstudents = [line.strip('\n').split(":")[0] for line in open("/home/who/Desktop/nonstudents")]

client = MongoClient()

db = client.university
db2 = client.mydb

users = db.users
nscl = db2.things

query = {}
projection = {'_id': 0, 'SCORE': 0, 'num_x_tweet': 0, 'num_keyword_tweet': 0, 'num_x_keyword': 0,
              'num_unique_x_keyword': 0,
              'x_tweets': 0, 'x_keywords': 0, 'date_last_x_keyword_tw': 0, 'statuses_count': 0, 'num_db_tweet': 0,
              'rate_fav': 0, 'avg_num_terms': 0, 'rate_photo': 0, 'rate_gif': 0, 'avg_num_chars': 0}

for ns in nonstudents:
    try:
        nsdoc = nscl.find_one({'ScreenName': ns}, projection)
        print(nsdoc)
        user = {
            "verified": nsdoc['IsVerified'],
            "lang": nsdoc['Language'],
            "created_at": nsdoc['CreatedDate'],
            "name": nsdoc['Name'],
            "friends_count": nsdoc['FriendsCount'],
            "followers_count": nsdoc['FollowersCount'],
            "favourites_count": nsdoc['FavouritesCount'],
            "id": nsdoc['TwitterId'],
            "protected": nsdoc['IsProtected'],
            "listed_count": nsdoc['ListedCount'],
            "description": nsdoc['Description'],
            "scree_name": nsdoc['ScreenName'],
            "default_profile": nsdoc['IsDefaultProfile'],
            "geo_enabled": nsdoc['IsGeoEnabled'],
            "withheld": nsdoc['Withheld'],
            "url": nsdoc['Url'],
            "twitter_age": nsdoc['twitter_age'],
            "rate_Turkish": nsdoc['rate_Turkish'],
            "hour_active": nsdoc['hour_active'],
            "rate_follow": nsdoc['rate_follow'],
            "rate_hashtags": nsdoc['rate_hashtags'],
            "rate_place": nsdoc['rate_place'],
            "rate_mention": nsdoc['rate_mentions'],
            "day_of_week_active": nsdoc['day_of_week_active'],
            "day_of_month_active": nsdoc['day_of_month_active'],
            "date_last_tweet": nsdoc['date_last_tweet'],
            "rate_url": nsdoc['rate_urls'],
            "rate_mobile": nsdoc['rate_mobile'],
            "rate_geo": nsdoc['rate_gps'],
            "rate_rt": nsdoc['rate_rt'],
            "university_student": 0
        }
        users.insert_one(user)


    except Exception as e:
        print("Unexpected error:", type(e), e)
