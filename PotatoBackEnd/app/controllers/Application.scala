package controllers
import model._
import model.formatters._
import play.api.libs.json._
import play.api.mvc._

class Application extends Controller {

  val r2 = Ok(views.html.index("Your new application is ready."))

  def index = Action {
//    val q1 = Question("title", Option("123") ,"checkbox")
//    val q1a = Question("title", Option("124"), "checkbox")
//
//    println(q1)
//    println(s"q1 == q1a ${q1 == q1a}")
//
//    val ls = 1::2::3::Nil
//    "a".equals("a")
//    "a" equals "a"
//
//    val q2 = q1.copy(id = Option("321"))
//    println(q2)
//    val r1 = Ok(views.html.index("Selam"))
    Ok(views.html.index("Your new application is ready."))
  }

  def login(id: String) = Action {

//    val user = UserInfo("thisisID","Mücahit","Kantepe","mkantepe@gmail.com","665161656132",Some("www"),Some("some notes"))

//    val a = (1 to 10) map {it =>
//      user.copy(id = Some(it.toString))
//    }

//    val mp = (1 to 10).foldLeft (Map.empty[String, UserInfo])((acc,userIterator) => acc + (userIterator.toString() -> user) )
//
//    val asd = Json.toJson(mp)
//    Ok(Json.prettyPrint(Json.toJson(mp)))
    Ok("")

  }

  def login3 = Action {
    Ok(<div>
      <h1>Merhaba</h1>
      <p>asd asd asd asd asd asd asd a</p>
    </div>).as("text/html")
  }

  def login2 = Action {
    Ok(views.html.login2("userabc"))
  }

  def getUserById(id: Int) = Action{

    println(id)

    Ok(<div>
      <h1>Merhaba</h1>
      <p>asd asd asd asd asd asd asd a</p>
    </div>).as("  text/html")

  }
}