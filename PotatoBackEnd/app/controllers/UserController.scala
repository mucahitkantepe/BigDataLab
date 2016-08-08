package controllers

import javax.inject.Inject
import dao.UserInfoDAO
import model._
import model.formatters._
import play.api.libs.json._
import play.api.mvc._
import slick.driver.PostgresDriver.api._
import play.api.libs.concurrent.Execution.Implicits.defaultContext

/**
  * Created by who on 03.08.2016.
  */
class UserController  @Inject()(userInfoDAO: UserInfoDAO) extends Controller{

  def addUserInfo = Action.async { request =>
    val userInfo = request.body.asJson.get.as[UserInfo]
     println(Json.toJson(userInfo.copy(email = "asdasd@gmail.com")))
    userInfoDAO.insert(userInfo).map(_ => Redirect(routes.Application.index()))
//    Ok(Json.toJson(userInfo.copy(email = "asdasd@gmail.com")))
  }

  def getUserByEmail() = Action{request =>
    val email = request.body.asJson.get.as[Email]
    Ok(email.email)
  }

  def updateUserInfo() = Action{request =>
    val userInfo = request.body.asJson.get.as[UserInfo]
    Ok(Json.toJson(userInfo))
  }

  def deleteUserInfo() = Action{request =>
    val userInfo = request.body.asJson.get.as[UserInfo]
    Ok(Json.toJson(userInfo))
  }
}
