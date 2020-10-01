ThisBuild / scalaVersion := "2.13.2"

lazy val root = (project in file("."))
  .settings(
    name := "basicScalaProject",
    libraryDependencies ++= Seq(
      // "org.scalatest" %% "scalatest" % "3.2.0" % Test
      "io.circe" %% "circe-core" % "0.12.3",
      "io.circe" %% "circe-generic" % "0.12.3",
      "io.circe" %% "circe-parser" % "0.12.3"
    )
  )