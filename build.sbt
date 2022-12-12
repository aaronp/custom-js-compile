ThisBuild /scalaVersion := "3.2.1"
name := "sbt-watch"
version := "0.0.1"


lazy val root = (project in file("."))
  .aggregate(server, client)

lazy val client = project
  .in(file("client"))
  .settings(name := "client")

lazy val server = project
  .in(file("server"))
  .settings(name := "server")
