package org.openchs.model.community

import java.sql.Date

import org.openchs.model.Person

case class Patient(patientId: String,
                   override val id: BigInt,
                   override val firstName: String,
                   override val middleName: String,
                   override val lastName: String,
                   override val dateOfBirth: Date) extends Person