package controllers

import play.api.mvc._

class HomeController(val controllerComponents: ControllerComponents) extends BaseController{
  def index = Action { request =>
    Ok("Adam, we're winning!")
  }

  def win(area: String) = Action { request =>
    Ok(s"amina & adam are winning at $area")
  }
}