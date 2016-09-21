package models

import org.joda.time.DateTime
import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
 * Created by fred on 17/04/2015.
 */

trait Sex
case object male extends Sex
case object female extends Sex

trait AddressType
case object personal extends AddressType // Petite correction: Sex devient AddressType
case object professional extends AddressType // Petite correction: Sex devient AddressType


case class Person(name:String, lastName:String, birthDate:DateTime, sex: Sex, addresses : Map[AddressType, Address] = Map.empty) {
  
  def age: Int = ???

  def professionalAddress: Option[Address] = ???

  def personalAddress: Option[Address]  = ???

}

object AddressType{
  //TODO hint : créer le Json Read et Write (ou Format)
  /*
    implicit val addressTypeFormat = new Format[AddressType] {
   def Writes(addressType: AddressType) = addressType match{
        case personal => val mySeq = Seq(
            "addressType" -> JsString("personal")
            )
        case professional => val mySeq = Seq(
            "addressType" -> JsString("professional")
            )
        JsObject(mySeq)
   }
    
    def Reads(jsonAddressType: JsValue) = {
        val addressType = (jsonAddressType \ "addressType").as[String]
        addressType match {
            case "personal" => personal
            case "professional" => professional
        }
    }
  }
  */
    implicit val addressTypeReads: Reads[AddressType] = (
      (JsPath \ "male").read[male] or
      (JsPath \ "female").read[female]
  )(AddressType.apply _)
  
  
 implicit val addressTypeWrites: Writes[AddressType] = (
      (JsPath \ "male").read[male] or
      (JsPath \ "female").read[female]
     )(unlift(Person.unapply))
}

object  Sex{
  //TODO hint : créer le Json Read et Write (ou Format)
  implicit val sexFormat = new Format[Sex] {
   def Writes(sex: Sex) = sex match{
        case male => JsObject(Seq(
            "sex" -> JsString("male")
            ))
        case female => JsObject(Seq(
            "sex" -> JsString("female")
            ))
   }
    
    def Reads(jsonSex: JsValue) = {
        val sex = (jsonSex \ "sex").as[String]
        sex match {
            case "male" => male
            case "female" => female
        }
    }
  }
}

object Person{
  //TODO hint : créer le Json Read et Write (ou Format)
  import Sex._
  import AddressType._
  import Address._
  
  //Here is my own custom Map Format:
  
  implicit val myMap = new Format[Map[AddressType, Address]]{
      def writeMyMap(map : Map[AddressType, Address]) = {
          val mySeq = Seq()
          map.foreach(
              (tuple : (AddressType, Address))  =>
              mySeq :+ Writes[tuple._1] :+ Writes[tuple._2]
              )
          JsObject(mySeq)
      }
      
      def readMyMap(jsonMyMap: JsValue) = {
        //TO DO
      }
      
      
      
  }


     
    
    
  implicit val personReads: Reads[Person] = (
      (JsPath \ "name").read[String] and
      (JsPath \ "lastName").read[String] and
      (JsPath \ "birthDate").read[DateTime] and
      (JsPath \ "sex").read[Sex] and
      (JsPath \ "addresses").read[Map[AddressType, Address]]
  )(Person.apply _)
  
  
 implicit val personWrites: Writes[Person] = (
      (JsPath \ "name").write[String] and
      (JsPath \ "lastName").write[String] and
      (JsPath \ "birthDate").write[DateTime] and
      (JsPath \ "sex").write[Sex] and
      (JsPath \ "addresses").write[Map[AddressType, Address]]
     )(unlift(Person.unapply))
  /*
  implicit val personFormat = new Format[Person] {
      def writes(person: Person) = {
          
          //Bulding a Seq for the Map[AddressType, Address]
          val addrSeq = Seq()
              person.addresses foreach(
                  tuple =>
                  addrSeq :+ Json.toJson(tuple._1) -> Json.toJson(tuple._2)
              )
              
              
          JsObject(Seq(
              "name" -> JsString(person.name),
              "lastName" -> JsString(person.lastName),
              "birthDate" -> Json.toJson(person.birthDate),
              "sex" -> Json.toJson(person.sex),
              "addresses" -> JsObject(addrSeq)
            ))
      }
      
        def reads(jsonPerson: JsValue) = {
            val name = (jsonPerson \ "name").as[String]
            val lastName = (jsonPerson \ "lastName").as[String]
            val birthDate = (jsonPerson \ "birthDate").as[DateTime]
            val sex = (jsonPerson \ "sex").read[Sex]
            val addresses : Map[AddressType, Address] = Map.empty
            person = Person(name, lastName, birthDate, sex, addresses)
    
      }
  }
  */
}

