package org.openchs.model.provider

import java.sql.Date

import org.openchs.model.Person


case class Provider(providerId: String,
                    override val id: BigInt,
                    override val firstName: String,
                    override val middleName: String,
                    override val lastName: String,
                    override val dateOfBirth: Date) extends Person