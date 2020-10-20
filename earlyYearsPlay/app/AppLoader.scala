import controllers.HomeController
import play.api.ApplicationLoader.Context
import play.api._
import play.filters.HttpFiltersComponents
import router.Routes

class AppLoader extends ApplicationLoader {
  def load(context: Context) = {
    new AppComponents(context).application
  }
}

class AppComponents(context: Context) extends BuiltInComponentsFromContext(context) with HttpFiltersComponents {
  val homeController = new HomeController(controllerComponents)
  lazy val router = new Routes(httpErrorHandler, homeController)
}