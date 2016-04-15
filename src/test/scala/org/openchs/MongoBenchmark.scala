package org.openchs

import faker.Name
import org.mongodb.scala._
import org.mongodb.scala.bson.BsonValue
import org.openchs.Helpers._
import org.mongodb.scala.model.Sorts._

class MongoBenchmark extends Mongo {
  "Benchmark postgresql" should "Insert queries" in {
    val patientCollection: MongoCollection[Document] = database.getCollection("patients")
    val maxIdDocument = patientCollection.find().sort(descending("_id")).first().results()
    val maxId: Int = maxIdDocument(0).get("_id").get.asInt32().intValue()
    val timeTaken = (1 to 10000).par.map(id => {
      val start = System.currentTimeMillis
      patientCollection.insertOne(Document("_id" -> (id + maxId), "firstName" -> Name.first_name, "middleName" -> Name.first_name, "lastName" -> Name.last_name, "dateOfBirth" -> "2015-01-01",
        "data" -> Document("type" -> Name.first_name, "value" -> Name.last_name))).results
      (System.currentTimeMillis - start) / 1000.0
    })
    println(s"The Average time taken ${timeTaken.sum / timeTaken.size}")
    println(s"The Median time taken ${timeTaken.toArray.sortWith(_ < _).drop(timeTaken.length / 2).head}")
  }

}
