import akka.http.scaladsl.server.Directives._
import api.SwdApi

/**
  * @author hanliqiang wrote on 2018/6/6
  */
trait Routes extends SwdApi {
  val routes = {
    pathPrefix("v1") {
      swdApi
    }
  }
}
