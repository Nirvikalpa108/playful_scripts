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


  val tweet1 = TweetRaw("a", LocalDate.now)
  val tweet2 = TweetRaw("b", LocalDate.now)
  val tweet3 = TweetRaw("c", LocalDate.now)
  val tweet4 = TweetRaw("d", LocalDate.now)
  val tweet5 = TweetRaw("e", LocalDate.now)
  val tweet6 = TweetRaw("f", LocalDate.now)
  val tweet7 = TweetRaw("g", LocalDate.now)
  val rawTweets: List[TweetRaw] = List(
    tweet1,
    tweet2,
    tweet3,
    tweet4,
    tweet5,
    tweet6,
    tweet7,
    )

  val userWithTweets: List[UserWithTweets] = List(
    UserWithTweets("a_adewusi", "Amina Adewusi", Some("url"), List(tweet1, tweet2, tweet3)),
    UserWithTweets("adamnfish", "Adam Fisher", Some("url"), List(tweet4, tweet5, tweet6, tweet7))
  )
}
