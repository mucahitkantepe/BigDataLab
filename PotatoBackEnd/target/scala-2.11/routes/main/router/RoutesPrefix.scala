
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/who/IdeaProjects/PotatoBackEnd/conf/routes
// @DATE:Wed Aug 03 14:25:58 EEST 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
