enablePlugins(JavaAppPackaging)

name := "akka-http-microservice"
organization := "com.theiterators"
version := "1.0.0"
scalaVersion := "2.12.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

//test in assembly := {}
//assemblyJarName in assembly := s"app-assembly.jar"
//assemblyMergeStrategy in assembly := {
//  case PathList("application.conf") => MergeStrategy.concat
//  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
//  case _ => MergeStrategy.first
//}
libraryDependencies ++= {
  val akkaV = "2.5.3"
  val akkaHttpV = "10.0.9"
  val scalaTestV = "3.0.1"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-testkit" % akkaV,
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV,
    "com.typesafe.play" %% "play-json" % "2.6.9",
    "com.typesafe.akka" %% "akka-stream-kafka" % "0.20",
    "org.scalatest" %% "scalatest" % scalaTestV % "test",
    "org.apache.httpcomponents" % "httpclient" % "4.5.5",
    "org.apache.kafka" %% "kafka" % "1.0.0"
  )
}
Revolver.settings
