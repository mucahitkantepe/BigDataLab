import operator
import re
from _datetime import datetime
from collections import defaultdict  # available in Python 2.5 and newer

from dateutil.relativedelta import relativedelta
from pymongo import MongoClient

client = MongoClient()

db = client.twitter

timeline = db.timeline
users = db.users

query = {}
projection = {'_id': 0}


def find(query):
    try:
        cursor = users.find(query, projection)

    except Exception as e:
        print("Unexpected error:", type(e), e)

    for user in cursor:
        num_of_terms = 0
        num_of_chars = 0
        retweeted_counter = 0
        date_last_tweet = datetime.min
        num_mentions = 0
        url_counter = 0
        place_counter = 0
        turkish_counter = 0
        mobile_counter = 0
        fav_counter = 0
        photo_counter = 0
        gif_counter = 0
        withheld = False
        followers = 0
        following = 0
        hashtag_counter = 0
        geo_counter = 0
        try:
            created_at = datetime.strptime(user['user']['created_at'], "%a %b %d %H:%M:%S +0000 %Y")
            twitter_age = relativedelta(datetime.now(), created_at).years
            users.update_one({'user.id': user['user']['id']}, {'$set': {'twitter_age': twitter_age}})
            num_db_tweet = timeline.find({'user.id': user['user']['id']}).count()
            users.update_one({'user.id': user['user']['id']}, {'$set': {'num_db_tweet': num_db_tweet}})

        except Exception as e:
            print(e)

        months = defaultdict(int)
        weeks = defaultdict(int)
        hours = defaultdict(int)
        tweets = timeline.find({'user.id': user['user']['id']}, projection)
        for tweet in tweets:

            try:

                if tweet['retweeted'] == 'true':    retweeted_counter += 1
                num_of_terms += len(re.findall(r'\w+', tweet['text']))
                num_of_chars += len(tweet['text'])
                created_at = datetime.strptime(tweet['created_at'], "%a %b %d %H:%M:%S +0000 %Y")
                months[created_at.month] += 1
                weeks[created_at.weekday()] += 1
                hours[created_at.hour] += 1

            except:
                pass

            try:
                if tweet['withheld_copyright'] == True:   withheld = True;
            except:
                pass

            if created_at > date_last_tweet:  date_last_tweet = created_at
            try:
                num_mentions += len(tweet['entities']['user_mentions'])
                hashtag_counter += len(tweet['entities']['hashtags'])
                url_counter += len(tweet['entities']['urls'])
                if tweet['place'] != None:    place_counter += 1
                if tweet['geo'] != None:    geo_counter += 1
                if tweet['lang'] == 'tr':    turkish_counter += 1
                if "Web" not in tweet['source']:    mobile_counter += 1
                fav_counter += tweet['favorite_count']
            except Exception as e:
                print(e)
            avg_num_terms = int(num_of_terms / tweets.count())
            try:
                photo_counter += len(
                    [element for element in tweet['extended_entities']['media'] if element['type'] == "photo"])
                gif_counter += len(
                    [element for element in tweet['extended_entities']['media'] if element['type'] == "animated_gif"])
            except:
                pass
            try:
                followers = tweet['user']['followers_count']
                following = tweet['user']['friends_count']
            except:
                pass
        avg_num_chars = int(num_of_chars / tweets.count())
        rate_rt = round(retweeted_counter / tweets.count(), 4)
        rate_url = round(url_counter / tweets.count(), 4)
        rate_mention = round(num_mentions / tweets.count(), 4)
        rate_place = round(place_counter / tweets.count(), 4)
        rate_mobile = round(mobile_counter / tweets.count(), 4)
        rate_fav = round(fav_counter / tweets.count(), 4)
        rate_photo = round(photo_counter / tweets.count(), 4)
        rate_gif = round(gif_counter / tweets.count(), 4)
        rate_follow = round((followers / following), 4)
        rate_turkish = round(turkish_counter / tweets.count(), 4)
        rate_hashtags = round(hashtag_counter / tweets.count(), 4)
        rate_geo = round(geo_counter / tweets.count(), 4)

        users.update_one({'user.id': user['user']['id']}, {'$set':
                                                               {'day_of_month_active':
                                                                    max(months.items(), key=operator.itemgetter(1))[0]
                                                                   , 'day_of_week_active':
                                                                    max(weeks.items(), key=operator.itemgetter(1))[0]
                                                                   , 'hour_active':
                                                                    max(hours.items(), key=operator.itemgetter(1))[0]
                                                                   , 'avg_num_terms': avg_num_terms
                                                                   , 'rate_rt': rate_rt
                                                                   , 'rate_url': rate_url
                                                                   , 'rate_mention': rate_mention
                                                                   , 'num_mention': num_mentions
                                                                   , 'rate_place': rate_place
                                                                   , 'rate_mobile': rate_mobile
                                                                   , 'rate_fav': rate_fav
                                                                   , 'rate_photo': rate_photo
                                                                   , 'rate_gif': rate_gif
                                                                   , 'withheld': withheld
                                                                   , 'rate_follow': rate_follow
                                                                   , 'rate_Turkish': rate_turkish
                                                                   , 'avg_num_chars': avg_num_chars
                                                                   , 'rate_hashtags': rate_hashtags
                                                                   , 'rate_geo': rate_geo
                                                                   , 'date_last_tweet': date_last_tweet
                                                                }})


find(query)
