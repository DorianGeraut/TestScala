name := """testscala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  "com.typesafe.play" %% "anorm" % "2.4.0",
  cache,
  ws,
  "org.reactivemongo" %% "play2-reactivemongo" % "0.11.14-play24",
  "org.reactivemongo" %% "reactivemongo-play-json" % "0.11.14"
)




fork in run := true