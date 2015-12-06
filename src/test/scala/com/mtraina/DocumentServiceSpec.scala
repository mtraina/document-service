package com.mtraina

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest

class DocumentServiceSpec extends Specification with Specs2RouteTest with DocumentService {
  def actorRefFactory = system

  "Document service" should {

    "return a greeting" in {
      Get() ~> serviceRoute ~> check {
        responseAs[String] must contain("hello world")
      }
    }

  }
}


