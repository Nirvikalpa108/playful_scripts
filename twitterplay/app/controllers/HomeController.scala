package controllers
import data.Database
import javax.inject._
import models.{Tweet, TweetRaw, TweetsResponse, User, UserWithTweets, UsersResponse}
import play.api._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  implicit val userWrites = Json.writes[User]
  implicit val tweetWrites = Json.writes[Tweet]
  implicit val tweetsWrites = Json.writes[TweetsResponse]

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

//  def tweetAsJson(tweet: Tweet): JsValue = {
//    Json.toJson(tweet)
//
//    //    s"""
////       |{ "tweet": "${tweet.tweet}",
////       |"timestamp": "${tweet.timestamp}",
////       |"author": {
////       |"handle": "${tweet.author.handle}",
////       |"name": "${tweet.author.name}",
////       |"avatar": "${tweet.author.avatar.getOrElse("error")}"
////       |}
////       |}
////       |""".stripMargin

////    Json.obj(
////      "tweet" -> tweet.tweet,
////      "timestamp" -> tweet.timestamp,
////      "author" -> Json.obj(
////        "handle" -> tweet.author.handle,
////        "name" -> tweet.author.name,
////        "avatar" -> tweet.author.avatar
////      )
////    )
//  }

  //  def tweetsAsJson(tweets: Tweet): JsValue = Json.toJson(tweets)

  def tweets() = Action {
    Ok(Json.toJson(TweetsResponse(Database.tweets)))

    //    val json =
    //      s"""
    //        |{
    //        |"tweets": [
    //        | ${tweetsJson}
    //        |]
    //        |}
    //        |""".stripMargin

    //    val jsonTwo = Json.obj(
    //      "tweets" -> Json.arr(
    //        tweetsJson
    //      )
    //    )
  }

//  def userTakeTwo(response: UserWithTweets): String = {
//    s"""
//       |{ "handle": "${response.handle}",
//       |  "name": "${response.name}",
//       |  "avatar": "${response.avatar}",
//       |  "tweets": [
//       |     { "text": "${response.tweets.map(_.text)}",
//       |       "timestamp": "${response.tweets.map(_.timestamp)}" }
//       |  ]
//       | }
//       |""".stripMargin
//  }

//  def user(response: UserWithTweets): String = {
//    s"""
//      |{ "handle": "${response.handle}",
//      |  "name": "${response.name}",
//      |  "avatar": "${response.avatar}",
//      |  "tweets": [
//      |     ${tweetsList}
//      |  ]
//      | }
//      |""".stripMargin
//  }

//  val tweetsList = Database.userWithTweets.map(_.tweets.map(tweet)).mkString(",")


  def tweet(tweet: TweetRaw): String = {
    s"""
       |{ "text": "${tweet.text}",
       |  "timestamp": "${tweet.timestamp}" }
       |""".stripMargin
  }

  def user(response: UserWithTweets): String = {
    s"""
       |{ "handle": "${response.handle}",
       |  "name": "${response.name}",
       |  "avatar": "${response.avatar}",
       |  "tweets": [
       |     ${response.tweets.map(tweet).mkString(",")}
       |  ]
       | }
       |""".stripMargin
  }

  val usersList = Database.userWithTweets.map(user).mkString(",")

  val json =
    s"""
      |{ "users" : [
      |   ${usersList}
      | ]
      |}
      |""".stripMargin

  def users() = Action {
    Ok(json)
  }

}
