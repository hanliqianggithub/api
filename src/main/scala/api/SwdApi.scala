package api

import akka.http.scaladsl.server.Directives.{entity, _}
import service.WeChatService

/**
  * @author hanliqiang wrote on 2018/6/6
  */
trait SwdApi {
  val swdApi =
    (post & entity(as[String])) { str =>
      complete {
        WeChatService.getWeChatValue(str).toString
      }
    }
}
