package org.openchs

import java.util.concurrent.atomic.AtomicInteger

import faker._
import scalikejdbc._

class FixtureCreation extends SQL {
  "Insert all Data" should "Should populate database" in {
    (1 to 33000000).par.map(id => {
      implicit val session = AutoSession
      sql"INSERT INTO patient VALUES(${id},${id.toString}, ${Name.first_name}, ${Name.first_name}, ${Name.last_name}, '2015-01-01')".update.apply()
      session.close()
    })
    (1 to 10000).par.map(id => {
      implicit val session = AutoSession
      sql"INSERT INTO provider VALUES(${id}, ${id.toString}, ${Name.first_name}, ${Name.first_name}, ${Name.last_name}, '2015-01-01')"
        .update.apply()
      sql"INSERT INTO facility VALUES(${id}, ${Name.first_name})".update.apply()
      session.close()
    })
    val start: AtomicInteger = new AtomicInteger(1)
    val end: AtomicInteger = new AtomicInteger(10000)
    (1 to 3300).foreach(id => {
      (start.get to end.get).par.map(sid => {
        implicit val session = AutoSession
        sql"INSERT INTO bulk_data VALUES(${sid}, ${id}, ${(sid % 1000) + 1}, ${Name.first_name})".update.apply()
        session.close()
      })
      start.getAndAdd(10000)
      end.getAndAdd(10000)
    })
  }

}
