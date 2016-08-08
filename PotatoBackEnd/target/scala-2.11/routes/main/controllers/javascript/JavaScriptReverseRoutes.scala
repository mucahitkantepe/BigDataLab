
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/who/IdeaProjects/PotatoBackEnd/conf/routes
// @DATE:Wed Aug 03 14:25:58 EEST 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:22
  class ReverseQuestionSetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def addQuestionSet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QuestionSetController.addQuestionSet",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminPanel/addQuestionSet"})
        }
      """
    )
  
    // @LINE:23
    def updateQuestionSet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QuestionSetController.updateQuestionSet",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminPanel/updateQuestionSet"})
        }
      """
    )
  
    // @LINE:24
    def deleteQuestionSet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QuestionSetController.deleteQuestionSet",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminPanel/deleteQuestionSet"})
        }
      """
    )
  
    // @LINE:25
    def getQuestionSetDetails: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QuestionSetController.getQuestionSetDetails",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminPanel/getQuestionSetDetails"})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseQuestionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def updateQuestion: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QuestionController.updateQuestion",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminPanel/updateQuestion"})
        }
      """
    )
  
    // @LINE:20
    def deleteQuestion: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QuestionController.deleteQuestion",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminPanel/deleteQuestion"})
        }
      """
    )
  
    // @LINE:18
    def addQuestion: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QuestionController.addQuestion",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminPanel/addQuestion"})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getUserByEmail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUserByEmail",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminPanel/getUserByEmail"})
        }
      """
    )
  
    // @LINE:13
    def addUserInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.addUserInfo",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addUserInfo"})
        }
      """
    )
  
    // @LINE:14
    def updateUserInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.updateUserInfo",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminPanel/updateUserInfo"})
        }
      """
    )
  
    // @LINE:15
    def deleteUserInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.deleteUserInfo",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminPanel/deleteUserInfo"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}
