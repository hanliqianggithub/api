import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.logRequestResult
import akka.stream.ActorMaterializer
import org.apache.log4j.{LogManager, Logger}
import utils.Config

import scala.concurrent.ExecutionContext

/**
  * @author hanliqiang wrote on 2018/6/6
  */
object Main extends App with Config with Routes {
  private implicit val system = ActorSystem()
  protected implicit val executor: ExecutionContext = system.dispatcher
  protected val log: LoggingAdapter = Logging(system, getClass)
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()
  Http().bindAndHandle(handler = logRequestResult("akka-http-microservice")(routes), interface = httpInterface, port = httpPort)
}
