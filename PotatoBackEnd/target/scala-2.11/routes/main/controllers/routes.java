
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/who/IdeaProjects/PotatoBackEnd/conf/routes
// @DATE:Wed Aug 03 14:25:58 EEST 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseQuestionSetController QuestionSetController = new controllers.ReverseQuestionSetController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseQuestionController QuestionController = new controllers.ReverseQuestionController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseQuestionSetController QuestionSetController = new controllers.javascript.ReverseQuestionSetController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseQuestionController QuestionController = new controllers.javascript.ReverseQuestionController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
  }

}
