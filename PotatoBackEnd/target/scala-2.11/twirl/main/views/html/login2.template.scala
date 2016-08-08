
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object login2_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class login2 extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userName : String = "defaultUser"):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.37*/("""

"""),format.raw/*3.1*/("""<div>
    <h1>
        Deneme2 : """),_display_(/*5.20*/{userName}),format.raw/*5.30*/("""
    """),format.raw/*6.5*/("""</h1>

</div>"""))
      }
    }
  }

  def render(userName:String): play.twirl.api.HtmlFormat.Appendable = apply(userName)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (userName) => apply(userName)

  def ref: this.type = this

}


}

/**/
object login2 extends login2_Scope0.login2
              /*
                  -- GENERATED --
                  DATE: Mon Aug 01 17:07:06 EEST 2016
                  SOURCE: /home/who/IdeaProjects/PotatoBackEnd/app/views/login2.scala.html
                  HASH: f99151a911b06e2bf13d7563ef48232327b245fe
                  MATRIX: 529->1|659->36|687->38|747->72|777->82|808->87
                  LINES: 20->1|25->1|27->3|29->5|29->5|30->6
                  -- GENERATED --
              */
          