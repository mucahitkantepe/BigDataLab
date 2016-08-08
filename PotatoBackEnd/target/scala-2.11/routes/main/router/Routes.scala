
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/who/IdeaProjects/PotatoBackEnd/conf/routes
// @DATE:Wed Aug 03 14:25:58 EEST 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_4: controllers.Application,
  // @LINE:9
  Assets_3: controllers.Assets,
  // @LINE:13
  UserController_1: controllers.UserController,
  // @LINE:18
  QuestionController_0: controllers.QuestionController,
  // @LINE:22
  QuestionSetController_2: controllers.QuestionSetController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_4: controllers.Application,
    // @LINE:9
    Assets_3: controllers.Assets,
    // @LINE:13
    UserController_1: controllers.UserController,
    // @LINE:18
    QuestionController_0: controllers.QuestionController,
    // @LINE:22
    QuestionSetController_2: controllers.QuestionSetController
  ) = this(errorHandler, Application_4, Assets_3, UserController_1, QuestionController_0, QuestionSetController_2, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_4, Assets_3, UserController_1, QuestionController_0, QuestionSetController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addUserInfo""", """controllers.UserController.addUserInfo()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminPanel/updateUserInfo""", """controllers.UserController.updateUserInfo()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminPanel/deleteUserInfo""", """controllers.UserController.deleteUserInfo()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminPanel/getUserByEmail""", """controllers.UserController.getUserByEmail()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminPanel/addQuestion""", """controllers.QuestionController.addQuestion()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminPanel/updateQuestion""", """controllers.QuestionController.updateQuestion()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminPanel/deleteQuestion""", """controllers.QuestionController.deleteQuestion()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminPanel/addQuestionSet""", """controllers.QuestionSetController.addQuestionSet()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminPanel/updateQuestionSet""", """controllers.QuestionSetController.updateQuestionSet()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminPanel/deleteQuestionSet""", """controllers.QuestionSetController.deleteQuestionSet()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminPanel/getQuestionSetDetails""", """controllers.QuestionSetController.getQuestionSetDetails()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_4.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_at1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
    Assets_3.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UserController_addUserInfo2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addUserInfo")))
  )
  private[this] lazy val controllers_UserController_addUserInfo2_invoker = createInvoker(
    UserController_1.addUserInfo(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "addUserInfo",
      Nil,
      "POST",
      """""",
      this.prefix + """addUserInfo"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_UserController_updateUserInfo3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminPanel/updateUserInfo")))
  )
  private[this] lazy val controllers_UserController_updateUserInfo3_invoker = createInvoker(
    UserController_1.updateUserInfo(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "updateUserInfo",
      Nil,
      "POST",
      """""",
      this.prefix + """adminPanel/updateUserInfo"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_UserController_deleteUserInfo4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminPanel/deleteUserInfo")))
  )
  private[this] lazy val controllers_UserController_deleteUserInfo4_invoker = createInvoker(
    UserController_1.deleteUserInfo(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "deleteUserInfo",
      Nil,
      "POST",
      """""",
      this.prefix + """adminPanel/deleteUserInfo"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_UserController_getUserByEmail5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminPanel/getUserByEmail")))
  )
  private[this] lazy val controllers_UserController_getUserByEmail5_invoker = createInvoker(
    UserController_1.getUserByEmail(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUserByEmail",
      Nil,
      "POST",
      """""",
      this.prefix + """adminPanel/getUserByEmail"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_QuestionController_addQuestion6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminPanel/addQuestion")))
  )
  private[this] lazy val controllers_QuestionController_addQuestion6_invoker = createInvoker(
    QuestionController_0.addQuestion(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionController",
      "addQuestion",
      Nil,
      "POST",
      """""",
      this.prefix + """adminPanel/addQuestion"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_QuestionController_updateQuestion7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminPanel/updateQuestion")))
  )
  private[this] lazy val controllers_QuestionController_updateQuestion7_invoker = createInvoker(
    QuestionController_0.updateQuestion(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionController",
      "updateQuestion",
      Nil,
      "POST",
      """""",
      this.prefix + """adminPanel/updateQuestion"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_QuestionController_deleteQuestion8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminPanel/deleteQuestion")))
  )
  private[this] lazy val controllers_QuestionController_deleteQuestion8_invoker = createInvoker(
    QuestionController_0.deleteQuestion(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionController",
      "deleteQuestion",
      Nil,
      "POST",
      """""",
      this.prefix + """adminPanel/deleteQuestion"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_QuestionSetController_addQuestionSet9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminPanel/addQuestionSet")))
  )
  private[this] lazy val controllers_QuestionSetController_addQuestionSet9_invoker = createInvoker(
    QuestionSetController_2.addQuestionSet(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionSetController",
      "addQuestionSet",
      Nil,
      "POST",
      """""",
      this.prefix + """adminPanel/addQuestionSet"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_QuestionSetController_updateQuestionSet10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminPanel/updateQuestionSet")))
  )
  private[this] lazy val controllers_QuestionSetController_updateQuestionSet10_invoker = createInvoker(
    QuestionSetController_2.updateQuestionSet(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionSetController",
      "updateQuestionSet",
      Nil,
      "POST",
      """""",
      this.prefix + """adminPanel/updateQuestionSet"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_QuestionSetController_deleteQuestionSet11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminPanel/deleteQuestionSet")))
  )
  private[this] lazy val controllers_QuestionSetController_deleteQuestionSet11_invoker = createInvoker(
    QuestionSetController_2.deleteQuestionSet(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionSetController",
      "deleteQuestionSet",
      Nil,
      "POST",
      """""",
      this.prefix + """adminPanel/deleteQuestionSet"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_QuestionSetController_getQuestionSetDetails12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminPanel/getQuestionSetDetails")))
  )
  private[this] lazy val controllers_QuestionSetController_getQuestionSetDetails12_invoker = createInvoker(
    QuestionSetController_2.getQuestionSetDetails(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionSetController",
      "getQuestionSetDetails",
      Nil,
      "GET",
      """""",
      this.prefix + """adminPanel/getQuestionSetDetails"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_4.index)
      }
  
    // @LINE:9
    case controllers_Assets_at1_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(Assets_3.at(path, file))
      }
  
    // @LINE:13
    case controllers_UserController_addUserInfo2_route(params) =>
      call { 
        controllers_UserController_addUserInfo2_invoker.call(UserController_1.addUserInfo())
      }
  
    // @LINE:14
    case controllers_UserController_updateUserInfo3_route(params) =>
      call { 
        controllers_UserController_updateUserInfo3_invoker.call(UserController_1.updateUserInfo())
      }
  
    // @LINE:15
    case controllers_UserController_deleteUserInfo4_route(params) =>
      call { 
        controllers_UserController_deleteUserInfo4_invoker.call(UserController_1.deleteUserInfo())
      }
  
    // @LINE:16
    case controllers_UserController_getUserByEmail5_route(params) =>
      call { 
        controllers_UserController_getUserByEmail5_invoker.call(UserController_1.getUserByEmail())
      }
  
    // @LINE:18
    case controllers_QuestionController_addQuestion6_route(params) =>
      call { 
        controllers_QuestionController_addQuestion6_invoker.call(QuestionController_0.addQuestion())
      }
  
    // @LINE:19
    case controllers_QuestionController_updateQuestion7_route(params) =>
      call { 
        controllers_QuestionController_updateQuestion7_invoker.call(QuestionController_0.updateQuestion())
      }
  
    // @LINE:20
    case controllers_QuestionController_deleteQuestion8_route(params) =>
      call { 
        controllers_QuestionController_deleteQuestion8_invoker.call(QuestionController_0.deleteQuestion())
      }
  
    // @LINE:22
    case controllers_QuestionSetController_addQuestionSet9_route(params) =>
      call { 
        controllers_QuestionSetController_addQuestionSet9_invoker.call(QuestionSetController_2.addQuestionSet())
      }
  
    // @LINE:23
    case controllers_QuestionSetController_updateQuestionSet10_route(params) =>
      call { 
        controllers_QuestionSetController_updateQuestionSet10_invoker.call(QuestionSetController_2.updateQuestionSet())
      }
  
    // @LINE:24
    case controllers_QuestionSetController_deleteQuestionSet11_route(params) =>
      call { 
        controllers_QuestionSetController_deleteQuestionSet11_invoker.call(QuestionSetController_2.deleteQuestionSet())
      }
  
    // @LINE:25
    case controllers_QuestionSetController_getQuestionSetDetails12_route(params) =>
      call { 
        controllers_QuestionSetController_getQuestionSetDetails12_invoker.call(QuestionSetController_2.getQuestionSetDetails())
      }
  }
}
