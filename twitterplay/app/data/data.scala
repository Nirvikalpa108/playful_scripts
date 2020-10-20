package data

import java.time.LocalDate

import models.{Tweet, User}

object Database {
  val user3 = User("", "", Some(""))
  val users: List[User] = List(
    User("", "", Some("")),
    User("", "", Some("")),
    user3
  )

  val tweets: List[Tweet] = List(
    Tweet("", LocalDate.now, users(0)),
    Tweet("", LocalDate.now, users(1)),
    Tweet("", LocalDate.now, user3),
  )

}
