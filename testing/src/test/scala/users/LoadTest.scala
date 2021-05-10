package users

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class LoadTest extends Simulation {

    val httpProtocol = http
      .baseUrl("http://localhost:8080")
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
      .acceptEncodingHeader("gzip, deflate")

    val scn = scenario("Load Test").
      forever {
        exec(http("Get List of Users")
          .get("/users"))
      }

    setUp(
        scn.inject(
          rampUsers(1) during (1))
          .throttle(
              reachRps(1) in (1), holdFor(20),
              reachRps(4) in (10),
              holdFor(20),
              reachRps(1) in (10), holdFor(20),
          ).protocols(httpProtocol))
    .maxDuration(60)

}
