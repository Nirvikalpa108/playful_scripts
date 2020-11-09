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

  // string interpolation for inner-inner frame - UNUSED CURRENTLY
  // not sure how to loop over tweets per user -
  // maybe different modelling of the data in the db?
  def tweet(tweet: TweetRaw): String = {
    s"""{ "text": ${tweet.text},
          "timestamp: ${tweet.timestamp}
        }""".stripMargin
  }

  // string interpolation for inner frame
  def user(response: UserWithTweets): String = {
    s"""
      |{ "handle": "${response.handle}",
      |  "name": "${response.name}",
      |  "avatar": "${response.avatar}",
      |  "tweets": [
      |    {"text": "${response.tweets.text}",
      |    "timestamp": "${response.tweets.timestamp}"}
      |  ]
      | }
      |""".stripMargin
  }

  // map over userWithTweets from the db and run it through the UsersAsJson function string
  val usersList = Database.userWithTweets.map(user).mkString(",")

  // this val is the string outer frame of the users array
  // it will take in a string interpolation mapped over
  // userWithTweets List from the Database
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
