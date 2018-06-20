package api

import akka.http.scaladsl.server.Directives.{entity, _}
import org.apache.log4j.{LogManager, Logger}
import service.CheckInService.getClass
import service.WeChatService

/**
  * @author hanliqiang wrote on 2018/6/6
  */
trait SwdApi {
  val LOGGER: Logger = LogManager.getLogger(getClass)
  val swdApi =
    (post & entity(as[String])) { str =>
      LOGGER.info("传过来的数据为："+str)
      complete {
        WeChatService.getWeChatValue(str).toString
      }
    }
}
