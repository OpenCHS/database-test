name := "database-test"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"

resolvers ++= Seq(
  DefaultMavenRepository
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0-M16-SNAP3" % "test"
)