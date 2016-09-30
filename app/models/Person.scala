package models

import models.Address

import org.joda.time.DateTime
import play.api.libs.json._
import play.api.libs.functional.syntax._


import com.fasterxml.jackson.databind.ObjectMapper
/*
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
*/

/**
 * Created by fred on 17/04/2015.
 */

trait Sex
case object Male extends Sex
case object Female extends Sex

trait AddressType
case object Personal extends AddressType // Petite correction: Sex devient AddressType
case object Professional extends AddressType // Petite correction: Sex devient AddressType


case class Person(name:String, lastName:String, birthDate:DateTime, sex: Sex, addresses : Map[AddressType, Address] = Map.empty) {
  
  def age: Int = ???

  def professionalAddress: Option[Address] = ???

  def personalAddress: Option[Address]  = ???

}



object AddressType{
  //TODO hint : créer le Json Read et Write (ou Format)

    def valueOf(value: String): AddressType = value match{
        case "professional" => Professional
        case "personal" => Personal
        case _ => throw new IllegalArgumentException()
    }
    
    def stringValueOf(value: AddressType): String = value match{
        case Professional => "professional"
        case Personal => "personal"
        case _ => throw new IllegalArgumentException()
    }
    
    implicit val addressTypeReads: Reads[AddressType] = 
      __.read[String].map(AddressType.valueOf)
    
    implicit val addressTypeWrites = Writes[AddressType]( addressType =>
        JsString(stringValueOf(addressType))
    )
}



object  Sex{
    //TODO hint : créer le Json Read et Write (ou Format)
    def valueOf(value: String): Sex = value match{
        case "male" => Male
        case "female" => Female
        case _ => throw new IllegalArgumentException()
    }
    
    def stringValueOf(value: Sex): String = value match{
        case Male => "male"
        case Female => "female"
        case _ => throw new IllegalArgumentException()
    }
    
    implicit val sexReads: Reads[Sex] = 
    __.read[String].map(Sex.valueOf)
    
    implicit val sexWrites = Writes[Sex]( sex =>
        JsString(stringValueOf(sex))
    )
  
}



object Person{
  //TODO hint : créer le Json Read et Write (ou Format)
  
  implicit val aread =  AddressType.addressTypeReads
  //Here I make my own Map[AddressType, Address] reads and writes:
  /*
    implicit val addrMapWrites = new Writes[Map[AddressType, Address]] {
     def writes(addrMap: Map[AddressType, Address]) = {
       val mySeq = Seq()
          addrMap foreach(
              tuple =>
              mySeq :+ "addressType" -> Json.toJson(tuple._1) :+ "address" -> Json.toJson(tuple._2)
              )
          JsObject(mySeq)
     }
    }

    implicit val addrMapReads = new Reads[Map[AddressType, Address]] {
        def reads(jsvalue: JsValue): JsResult[Map[AddressType, Address]] = {
            val mapper = new ObjectMapper() with ScalaObjectMapper
            mapper.registerModule(DefaultScalaModule)
            val mapData = mapper.readValue(jsonContent, classOf[Map[AddressType, Address]])   
        
        }
    }
    */
    
  implicit val personReads: Reads[Person] = (
      (JsPath \ "name").read[String] and
      (JsPath \ "lastName").read[String] and
      (JsPath \ "birthDate").read[DateTime] and
      (JsPath \ "sex").read[Sex] and
      (JsPath \ "addresses").read[Map[AddressType, Address]]
  )(Person.apply _)
  
  
 implicit val personWrites = new Writes[Person] {
     def writes(person: Person) = Json.obj(
         "name" -> person.name,
         "lastName" -> person.lastName,
         "birthDate" -> person.birthDate,
         "sex" -> person.sex,
         "addresses" -> person.addresses
         )
 }
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

