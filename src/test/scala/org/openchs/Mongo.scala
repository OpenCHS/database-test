package org.openchs

import org.mongodb.scala.{MongoDatabase, MongoClient}
import org.scalatest.{Matchers, FlatSpec}

trait Mongo extends FlatSpec with Matchers {
  val mongoClient = MongoClient()
  val database: MongoDatabase = mongoClient.getDatabase("dbtest")
}
