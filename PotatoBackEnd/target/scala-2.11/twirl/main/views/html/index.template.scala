
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""

    """),format.raw/*5.5*/("""<h1>
        """),_display_(/*6.10*/message),format.raw/*6.17*/("""
    """),format.raw/*7.5*/("""</h1>
""")))}),format.raw/*8.2*/("""
"""))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Mon Aug 01 17:26:36 EEST 2016
                  SOURCE: /home/who/IdeaProjects/PotatoBackEnd/app/views/index.scala.html
                  HASH: 694713a525d5e9c6b97515982a29cd466f829198
                  MATRIX: 527->1|639->18|667->21|698->44|737->46|769->52|809->66|836->73|867->78|903->85
                  LINES: 20->1|25->1|27->3|27->3|27->3|29->5|30->6|30->6|31->7|32->8
                  -- GENERATED --
              */
          