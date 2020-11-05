package controllers
import data.Database
import javax.inject._
import models.{Tweet, Response, User}
import play.api._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  implicit val userWrites = Json.writes[User]
  implicit val tweetWrites = Json.writes[Tweet]
  implicit val tweetsWrites = Json.writes[Response]

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
    Ok(Json.toJson(Response(Database.tweets)))

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
}
