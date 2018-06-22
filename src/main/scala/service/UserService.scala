package service

import org.apache.log4j.{LogManager, Logger}
import play.api.libs.json._
import utils.HttpUtil

/**
  * @author hanliqiang wrote on 2018/6/11
  */
object UserService {
  val LOGGER: Logger = LogManager.getLogger(getClass)

  def sendUser(param: String): String = {
    val json = Json.parse(param)
    println(json)
    val openId = (json \ "WxOpenID")
    var content: String = ""
    if (openId.isEmpty == false) {
      content = HttpUtil.doGet("WxUser/" + openId.as[String])
//      val data = new ProducerRecord[String, String]("topic_wxuser", content)
//      KafkaUtil.createProducer().send(data)
      LOGGER.info("topic  topic_wxuser 发送成功")
    }
    LOGGER.info("没有 WxOpenID")
    content
  }
}
