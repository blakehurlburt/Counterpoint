scalacOptions ++= Seq(
    "-language:implicitConversions",
    "-language:postfixOps",
    "-feature",
)

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"
