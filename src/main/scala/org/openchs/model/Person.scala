package org.openchs.model

import java.sql.Date

trait Person {
  val id: BigInt
  val firstName: String
  val middleName: String
  val lastName: String
  val dateOfBirth: Date
}

