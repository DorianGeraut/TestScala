// @SOURCE:/home/dorian/workspace/Stage/TestScala/conf/routes
// @HASH:4ad3e2b460ba473089435ff009f11e599ac89e97
// @DATE:Fri Sep 30 08:33:51 CEST 2016


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:10
private[this] lazy val controllers_PersonController_list1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person"))))
private[this] lazy val controllers_PersonController_list1_invoker = createInvoker(
controllers.PersonController.list,
HandlerDef(this.getClass.getClassLoader, "", "controllers.PersonController", "list", Nil,"GET", """""", Routes.prefix + """person"""))
        

// @LINE:11
private[this] lazy val controllers_PersonController_create2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/create"))))
private[this] lazy val controllers_PersonController_create2_invoker = createInvoker(
controllers.PersonController.create,
HandlerDef(this.getClass.getClassLoader, "", "controllers.PersonController", "create", Nil,"POST", """""", Routes.prefix + """person/create"""))
        

// @LINE:12
private[this] lazy val controllers_PersonController_remove3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/remove/"),DynamicPart("name", """[^/]+""",true))))
private[this] lazy val controllers_PersonController_remove3_invoker = createInvoker(
controllers.PersonController.remove(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PersonController", "remove", Seq(classOf[String]),"POST", """""", Routes.prefix + """person/remove/$name<[^/]+>"""))
        

// @LINE:14
private[this] lazy val controllers_AddressController_add4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("address/add/"),DynamicPart("personId", """[^/]+""",true),StaticPart("/"),DynamicPart("typeAddress", """[^/]+""",true))))
private[this] lazy val controllers_AddressController_add4_invoker = createInvoker(
controllers.AddressController.add(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.AddressController", "add", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """address/add/$personId<[^/]+>/$typeAddress<[^/]+>"""))
        

// @LINE:15
private[this] lazy val controllers_AddressController_update5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("address/update/"),DynamicPart("personId", """[^/]+""",true),StaticPart("/"),DynamicPart("typeAddress", """[^/]+""",true))))
private[this] lazy val controllers_AddressController_update5_invoker = createInvoker(
controllers.AddressController.update(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.AddressController", "update", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """address/update/$personId<[^/]+>/$typeAddress<[^/]+>"""))
        

// @LINE:16
private[this] lazy val controllers_AddressController_remove6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("address/remove/"),DynamicPart("personId", """[^/]+""",true),StaticPart("/"),DynamicPart("typeAddress", """[^/]+""",true))))
private[this] lazy val controllers_AddressController_remove6_invoker = createInvoker(
controllers.AddressController.remove(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.AddressController", "remove", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """address/remove/$personId<[^/]+>/$typeAddress<[^/]+>"""))
        

// @LINE:19
private[this] lazy val controllers_Assets_at7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at7_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person""","""controllers.PersonController.list"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/create""","""controllers.PersonController.create"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/remove/$name<[^/]+>""","""controllers.PersonController.remove(name:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """address/add/$personId<[^/]+>/$typeAddress<[^/]+>""","""controllers.AddressController.add(personId:String, typeAddress:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """address/update/$personId<[^/]+>/$typeAddress<[^/]+>""","""controllers.AddressController.update(personId:String, typeAddress:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """address/remove/$personId<[^/]+>/$typeAddress<[^/]+>""","""controllers.AddressController.remove(personId:String, typeAddress:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:10
case controllers_PersonController_list1_route(params) => {
   call { 
        controllers_PersonController_list1_invoker.call(controllers.PersonController.list)
   }
}
        

// @LINE:11
case controllers_PersonController_create2_route(params) => {
   call { 
        controllers_PersonController_create2_invoker.call(controllers.PersonController.create)
   }
}
        

// @LINE:12
case controllers_PersonController_remove3_route(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        controllers_PersonController_remove3_invoker.call(controllers.PersonController.remove(name))
   }
}
        

// @LINE:14
case controllers_AddressController_add4_route(params) => {
   call(params.fromPath[String]("personId", None), params.fromPath[String]("typeAddress", None)) { (personId, typeAddress) =>
        controllers_AddressController_add4_invoker.call(controllers.AddressController.add(personId, typeAddress))
   }
}
        

// @LINE:15
case controllers_AddressController_update5_route(params) => {
   call(params.fromPath[String]("personId", None), params.fromPath[String]("typeAddress", None)) { (personId, typeAddress) =>
        controllers_AddressController_update5_invoker.call(controllers.AddressController.update(personId, typeAddress))
   }
}
        

// @LINE:16
case controllers_AddressController_remove6_route(params) => {
   call(params.fromPath[String]("personId", None), params.fromPath[String]("typeAddress", None)) { (personId, typeAddress) =>
        controllers_AddressController_remove6_invoker.call(controllers.AddressController.remove(personId, typeAddress))
   }
}
        

// @LINE:19
case controllers_Assets_at7_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at7_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     