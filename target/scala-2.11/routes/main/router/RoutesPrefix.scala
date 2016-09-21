
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/dorian/workspace/Stage/TestScala/conf/routes
// @DATE:Thu Sep 15 20:25:37 CEST 2016


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
