name := """play_scala_app"""
organization := "com.amadeus"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies += filters
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test
libraryDependencies += "commons-codec" % "commons-codec" % "1.9"

libraryDependencies ++= Seq(
jdbc,
cache,
ws,
"mysql" % "mysql-connector-java" % "5.1.36").map(_.exclude("org.slf4j", "slf4j-jdk14"))

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.amadeus.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.amadeus.binders._"
