package models

import play.api.libs.json._
import play.api.libs.functional.syntax._
/**
 * Created by fred on 17/04/2015.
 */
 
case class Address(street : String, town:String, zipCode:String)


object Address{
  //TODO json Format
  
  
  implicit val addressReads: Reads[Address] = (
      (JsPath \ "street").read[String] and
      (JsPath \ "town").read[String] and
      (JsPath \ "zipCode").read[String]
   )(Address.apply _)
  
   implicit val addressWrites = new Writes[Address] {
       def writes(address: Address) = Json.obj(
           "street" -> address.street,
           "town" -> address.town,
           "zipCode" -> address.zipCode
           )
   }
}