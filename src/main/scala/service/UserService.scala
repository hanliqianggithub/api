package service

import org.apache.kafka.clients.producer.ProducerRecord
import play.api.libs.json.Json
import utils.{HttpUtil, KafkaUtil}

/**
  * @author hanliqiang wrote on 2018/6/11
  */
object UserService {
  def sendUser(param: String): Unit = {
    val json = Json.parse(param)
    val openId = (json \ "WxOpenID")
    var content: String = ""
    if (openId.isEmpty == false) {
      content = HttpUtil.doGet("WxUser/" + openId.as[String])
      val data = new ProducerRecord[String, String]("topic_wxuser", content)
      KafkaUtil.createProducer().send(data)
      println("topic  topic_wxuser 发送成功")
    }
  }
}
