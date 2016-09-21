package models

import play.api.libs.json._

/**
 * Created by fred on 17/04/2015.
 */
case class Address(street : String, town:String, zipCode:String)


object Address{
  //TODO json Format
  implicit val addressFormat = new Format[Address] {
      def Writes(address: Address) = {
          JsObject(Seq(
              "street" -> JsString(address.street),
              "town" -> JsString(address.town),
              "zipCode" -> JsString(address.zipCode)
          ))
      }
    
    def Reads(jsonAdress: JsValue) = {
        val street = (jsonAdress \ "street").as[String]
        val town = (jsonAdress \ "town").as[String]
        val zipCode = (jsonAdress \ "zipCode").as[String]
        Address(street,town,zipCode)
    }
      
  }
}