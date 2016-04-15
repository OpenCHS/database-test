name := "database-test"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"

resolvers ++= Seq(
  DefaultMavenRepository,
  "justwrote" at "http://repo.justwrote.it/releases/"
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0-M16-SNAP3" % "test",
  "it.justwrote" %% "scala-faker" % "0.3",
  "org.scalikejdbc" %% "scalikejdbc" % "2.3.5",
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "org.postgresql" % "postgresql" % "9.4.1208",
  "org.mongodb.scala" %% "mongo-scala-driver" % "1.0.0"
)