ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "childDevelopment",
    libraryDependencies ++= Seq(
      "org.xerial" % "sqlite-jdbc" % "3.32.3.2",
      "org.playframework.anorm" %% "anorm" % "2.6.7",
      "org.scalatest" %% "scalatest" % "3.2.0" % Test
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
