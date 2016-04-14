package org.openchs.model

trait Group {
  val members: Set[_ <: Person] = Set()
}