package models

import java.time.LocalDate

case class User(handle: String, name: String, avatar: Option[String])

case class Tweet(tweet: String, timestamp: LocalDate, author: User)
