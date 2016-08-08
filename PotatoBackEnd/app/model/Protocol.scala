package model

import play.api.libs.json._

case class QuestionOption(id : String, text : String = "", weight : Double)
case class Question (title : String, id : String, qtype : String, options : List[QuestionOption] = Nil, setList : List[String] = Nil)
case class UserInfo(name : String, lastname : String,email: String, phone : String,photo:Option[String] = Some(""), website : Option[String] = Some(""), notes: Option[String]=Some(""))
case class Email(email : String)
case class Category(category : String, weight : Double)
case class QuestionSet(title : String, count: Option[Int] = Option(0), id : String)
case class Answer(questionID: String, value:List[String] = Nil)
case class Answers(answers : List[Answer], date : String, userID : String)

object formatters  {
   implicit  val userInfoFormat = Json.format[UserInfo]
   implicit  val questionOptionFormat = Json.format[QuestionOption]
   implicit  val questionFormat = Json.format[Question]
   implicit  val emailFormat = Json.format[Email]
   implicit  val categoryFormat = Json.format[Category]
   implicit  val questionSetFormat = Json.format[QuestionSet]
   implicit  val answerFormat = Json.format[Answer]
   implicit  val answersFormat = Json.format[Answers]
}
