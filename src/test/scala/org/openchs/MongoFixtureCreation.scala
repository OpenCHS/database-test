package org.openchs

import java.util.concurrent.atomic.AtomicInteger

import faker._
import org.mongodb.scala.model._
import org.mongodb.scala.{MongoCollection, _}
import org.openchs.Helpers._

class MongoFixtureCreation extends Mongo {

  "Insert all Data" should "Should populate database" in {
        val providerCollection: MongoCollection[Document] = database.getCollection("providers")
        providerCollection.bulkWrite((1 to 10000).par.map(id => InsertOneModel(Document("_id" -> id, "firstName" -> Name.first_name, "middleName" -> Name.first_name, "lastName" -> Name.last_name, "dateOfBirth" -> "2015-01-01"))).to[Seq]).results

        val facilitiesCollection: MongoCollection[Document] = database.getCollection("facilities")
        facilitiesCollection.bulkWrite((1 to 10000).par.map(id => InsertOneModel(Document("_id" -> id, "name" -> Name.name))).to[Seq]).results

    val patientCollection: MongoCollection[Document] = database.getCollection("patients")
    val start: AtomicInteger = new AtomicInteger(1)
    val end: AtomicInteger = new AtomicInteger(10000)
    (1 to 3300).foreach(id => {
      patientCollection.bulkWrite((start.get to end.get).par.map(id => InsertOneModel(Document("_id" -> id, "firstName" -> Name.first_name, "middleName" -> Name.first_name, "lastName" -> Name.last_name, "dateOfBirth" -> "2015-01-01",
        "data" -> Document("type" -> Name.first_name, "value" -> Name.last_name)))).to[Seq]).results
      start.getAndAdd(10000)
      end.getAndAdd(10000)
    })
  }

}
