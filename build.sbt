name := """oc-play"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala, SbtReactiveAppPlugin)

scalaVersion := "2.12.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

endpoints := HttpEndpoint(
    name = "http",
    ingress = new HttpIngress(
        ingressPorts = Vector(80, 443),
        hosts = Vector.empty,
        paths = Vector("/")
    )
) :: Nil


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
