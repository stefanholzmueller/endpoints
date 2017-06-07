package endpoints.scalaj.client

import endpoints.testsuite.{BasicAuthTestApi, SimpleTestApi}
import endpoints.testsuite.client.{BasicAuthTestSuite, SimpleTestSuite}

class TestClient(val address: String) extends SimpleTestApi
  with BasicAuthTestApi
  with Endpoints
  with BasicAuthentication

class EndpointsTest extends SimpleTestSuite[TestClient] with BasicAuthTestSuite[TestClient] {

  val client: TestClient = new TestClient(s"localhost:$wiremockPort")

  def call[Req, Resp](endpoint: client.Endpoint[Req, Resp], args: Req): Resp = endpoint.callUnsafe(args)


  clientTestSuite()

  basicAuthSuite()

}
