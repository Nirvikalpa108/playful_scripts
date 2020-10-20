package controllers

import play.api.mvc._

class HomeController(val controllerComponents: ControllerComponents) extends BaseController{
  def index = Action { request =>
    Ok("Adam, we're winning!")
  }

  def api(age: String, area: String) = Action { request =>
    Ok(s"My child is $age months old and I am interested in their $area")
  }
}