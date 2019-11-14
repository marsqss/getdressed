name := "GetDressed"

version := "1.0.1"

scalaVersion := "2.12.2"

lazy val akkaVersion = "2.5.11"

libraryDependencies ++= Seq(
  "ch.qos.logback"     %  "logback-classic" % "1.0.13",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

mainClass in Compile := Some("com.getdress.GetDressApp")

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-Xlint",
  "-Ywarn-unused",
  "-Ywarn-dead-code",
  "-feature",
  "-language:_"
)

scriptClasspath +="../conf"

enablePlugins(JavaAppPackaging)

bashScriptTemplateLocation := new File("src/main/resources/bash-template")