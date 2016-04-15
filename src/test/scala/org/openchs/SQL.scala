package org.openchs

import org.scalatest.{Matchers, FlatSpec}
import scalikejdbc._


trait SQL extends FlatSpec with Matchers {
  GlobalSettings.loggingSQLAndTime = LoggingSQLAndTimeSettings(
    enabled = false,
    singleLineMode = false,
    printUnprocessedStackTrace = false,
    stackTraceDepth = 15,
    logLevel = 'error,
    warningEnabled = false,
    warningThresholdMillis = 3000L,
    warningLogLevel = 'error
  )

  Class.forName("org.postgresql.Driver")
  ConnectionPool.singleton("jdbc:postgresql:dbtest", "mihir", "")
}
