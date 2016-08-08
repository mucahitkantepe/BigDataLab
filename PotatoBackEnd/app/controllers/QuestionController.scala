package controllers

import model._
import model.formatters._
import play.api.mvc._

/**
  * Created by who on 03.08.2016.
  */
class QuestionController extends Controller{

  def addQuestion() = Action{ request =>
    val question = request.body.asJson.get.as[Question]
    Ok("1")
  }

  def updateQuestion() = Action{request =>
    val question = request.body.asJson.get.as[Question]
    Ok("1")

  }

  def deleteQuestion() = Action {request =>
    val question = request.body.asJson.get.as[Question]
    Ok("1")

  }
}
