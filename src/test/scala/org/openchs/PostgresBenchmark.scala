package org.openchs

import faker.Name
import scalikejdbc._


class PostgresBenchmark extends SQL {
  "Benchmark postgresql" should "Insert queries" in {
    implicit val session = AutoSession
    val maxId = sql"SELECT max(id) FROM bulk_data".map(_.int(1)).single.apply().get
    session.close
    val timeTaken = (1 to 10000).par.map(id => {
      val start = System.currentTimeMillis
      implicit val session = AutoSession
      sql"INSERT INTO bulk_data (id, patient_id, provider_id, value) VALUES (${maxId + id}, ${id}, ${id}, ${Name.name})".update.apply()
      session.close
      (System.currentTimeMillis - start) / 1000.0
    })
    println(s"The Average time taken ${timeTaken.sum / timeTaken.size}")
    println(s"The Median time taken ${timeTaken.toArray.sortWith(_ < _).drop(timeTaken.length / 2).head}")
  }

}
