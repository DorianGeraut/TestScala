// @SOURCE:/home/dorian/workspace/Stage/TestScala/conf/routes
// @HASH:4ad3e2b460ba473089435ff009f11e599ac89e97
// @DATE:Fri Sep 30 08:33:51 CEST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:19
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers {

// @LINE:12
// @LINE:11
// @LINE:10
class ReversePersonController {


// @LINE:12
def remove(name:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "person/remove/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
}
                        

// @LINE:10
def list(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "person")
}
                        

// @LINE:11
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "person/create")
}
                        

}
                          

// @LINE:16
// @LINE:15
// @LINE:14
class ReverseAddressController {


// @LINE:14
def add(personId:String, typeAddress:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "address/add/" + implicitly[PathBindable[String]].unbind("personId", dynamicString(personId)) + "/" + implicitly[PathBindable[String]].unbind("typeAddress", dynamicString(typeAddress)))
}
                        

// @LINE:16
def remove(personId:String, typeAddress:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "address/remove/" + implicitly[PathBindable[String]].unbind("personId", dynamicString(personId)) + "/" + implicitly[PathBindable[String]].unbind("typeAddress", dynamicString(typeAddress)))
}
                        

// @LINE:15
def update(personId:String, typeAddress:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "address/update/" + implicitly[PathBindable[String]].unbind("personId", dynamicString(personId)) + "/" + implicitly[PathBindable[String]].unbind("typeAddress", dynamicString(typeAddress)))
}
                        

}
                          

// @LINE:19
class ReverseAssets {


// @LINE:19
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          
}
                  


// @LINE:19
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:12
// @LINE:11
// @LINE:10
class ReversePersonController {


// @LINE:12
def remove : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonController.remove",
   """
      function(name) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "person/remove/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name))})
      }
   """
)
                        

// @LINE:10
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonController.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "person"})
      }
   """
)
                        

// @LINE:11
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "person/create"})
      }
   """
)
                        

}
              

// @LINE:16
// @LINE:15
// @LINE:14
class ReverseAddressController {


// @LINE:14
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AddressController.add",
   """
      function(personId,typeAddress) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "address/add/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("personId", encodeURIComponent(personId)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("typeAddress", encodeURIComponent(typeAddress))})
      }
   """
)
                        

// @LINE:16
def remove : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AddressController.remove",
   """
      function(personId,typeAddress) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "address/remove/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("personId", encodeURIComponent(personId)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("typeAddress", encodeURIComponent(typeAddress))})
      }
   """
)
                        

// @LINE:15
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AddressController.update",
   """
      function(personId,typeAddress) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "address/update/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("personId", encodeURIComponent(personId)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("typeAddress", encodeURIComponent(typeAddress))})
      }
   """
)
                        

}
              

// @LINE:19
class ReverseAssets {


// @LINE:19
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:6
class ReverseApplication {


// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              
}
        


// @LINE:19
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers.ref {


// @LINE:12
// @LINE:11
// @LINE:10
class ReversePersonController {


// @LINE:12
def remove(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonController.remove(name), HandlerDef(this.getClass.getClassLoader, "", "controllers.PersonController", "remove", Seq(classOf[String]), "POST", """""", _prefix + """person/remove/$name<[^/]+>""")
)
                      

// @LINE:10
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonController.list(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PersonController", "list", Seq(), "GET", """""", _prefix + """person""")
)
                      

// @LINE:11
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonController.create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PersonController", "create", Seq(), "POST", """""", _prefix + """person/create""")
)
                      

}
                          

// @LINE:16
// @LINE:15
// @LINE:14
class ReverseAddressController {


// @LINE:14
def add(personId:String, typeAddress:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AddressController.add(personId, typeAddress), HandlerDef(this.getClass.getClassLoader, "", "controllers.AddressController", "add", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """address/add/$personId<[^/]+>/$typeAddress<[^/]+>""")
)
                      

// @LINE:16
def remove(personId:String, typeAddress:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AddressController.remove(personId, typeAddress), HandlerDef(this.getClass.getClassLoader, "", "controllers.AddressController", "remove", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """address/remove/$personId<[^/]+>/$typeAddress<[^/]+>""")
)
                      

// @LINE:15
def update(personId:String, typeAddress:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AddressController.update(personId, typeAddress), HandlerDef(this.getClass.getClassLoader, "", "controllers.AddressController", "update", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """address/update/$personId<[^/]+>/$typeAddress<[^/]+>""")
)
                      

}
                          

// @LINE:19
class ReverseAssets {


// @LINE:19
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          
}
        
    