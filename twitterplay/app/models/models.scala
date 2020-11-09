package models

import java.time.LocalDate

case class User(handle: String, name: String, avatar: Option[String])

case class Tweet(tweet: String, timestamp: LocalDate, author: User)

case class TweetsResponse(tweets: List[Tweet])



case class TweetRaw(text: String, timestamp: LocalDate)

case class UserWithTweets(handle: String, name: String, avatar: Option[String], tweets: TweetRaw)

case class UsersResponse(users: List[UserWithTweets])


