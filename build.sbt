enablePlugins(JavaAppPackaging)

name := "akka-http-microservice"
organization := "com.theiterators"
version := "1.0.0"
scalaVersion := "2.12.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

assemblyJarName in assembly := s"app-assembly.jar"
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
    "com.typesafe.akka" %% "akka-slf4j" % akkaV,
//    "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
    "com.typesafe.play" %% "play-json" % "2.6.9",
    "com.typesafe.akka" %% "akka-stream-kafka" % "0.20",
    "org.scalatest" %% "scalatest" % scalaTestV % "test",
    "org.apache.httpcomponents" % "httpclient" % "4.5.5",
    "org.apache.kafka" %% "kafka" % "1.0.0"
//    "net.logstash.logback" %% "logstash-logback-encoder" % "4.11"
  )
}
Revolver.settings
