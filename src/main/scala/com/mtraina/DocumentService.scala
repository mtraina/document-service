package com.mtraina

import akka.actor.{ActorRefFactory, Actor}
import spray.http._
import spray.routing._
import MediaTypes._

class DocumentServiceActor extends Actor with DocumentService {
  implicit val system = context.system

  override def receive: Receive = runRoute(serviceRoute)

  override implicit def actorRefFactory: ActorRefFactory = context
}

trait DocumentService extends HttpService {
  val serviceRoute =
    path(""){
      get {
        respondWithMediaType(`text/html`){
          complete {
            <html>
              <body>
                <h1>hello world from spray-routing using spray-can</h1>
              </body>
            </html>
          }
        }
      }
    }
}
