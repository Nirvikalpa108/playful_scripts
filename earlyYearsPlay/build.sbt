name := "earlyYearsDevelopment"

libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)
