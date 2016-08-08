package controllers
import model._
import model.formatters._
import play.api.mvc._

/**
  * Created by who on 03.08.2016.
  */
class QuestionSetController extends Controller{


  def updateQuestionSet() = Action{request =>
    val questionSet = request.body.asJson.get.as[QuestionSet]
    Ok("asd")

  }


  def deleteQuestionSet() = Action{request =>
    val questionSet = request.body.asJson.get.as[QuestionSet]
    Ok("asd")
  }
  def getQuestionSetDetails() = Action  {
    Ok("asd")
    //List[QuestionSet] olarak db'deki tüm questionSetleri dönecek.
  }


  def addQuestionSet() = Action{ request =>
    val questionSet = request.body.asJson.get.as[QuestionSet]
    Ok("asd")
    // Aynı isimde set var mı diye falan kontrol eklenmesi gerekebilir
  }

}
