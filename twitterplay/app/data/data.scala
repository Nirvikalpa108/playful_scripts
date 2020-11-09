package data

import java.time.LocalDate

import models.{Tweet, TweetRaw, TweetsResponse, User, UserWithTweets}

object Database {
  val user3 = User("a_adewusi", "Amina Adewusi", Some("url"))
  val users: List[User] = List(
    User("adamnfish", "Adam Fisher", Some("url")),
    User("nice winner", "The Nice Winner", Some("url")),
    user3
  )

  val tweets: List[Tweet] =  List(
    Tweet("I am winning", LocalDate.now, users(0)),
    Tweet("I won", LocalDate.now, users(1)),
    Tweet("I'm still winning", LocalDate.now, user3),
  )

  val rawTweets: List[TweetRaw] = List(
    TweetRaw("a", LocalDate.now),
    TweetRaw("b", LocalDate.now)
    )

  val userWithTweets: List[UserWithTweets] = List(
    UserWithTweets("a_adewusi", "Amina Adewusi", Some("url"), rawTweets(0)),
    UserWithTweets("adamnfish", "Adam Fisher", Some("url"), rawTweets(1))
  )
}
