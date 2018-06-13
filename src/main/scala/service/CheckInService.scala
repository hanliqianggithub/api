package service

import org.apache.kafka.clients.producer.ProducerRecord
import play.api.libs.json.Json
import utils.{HttpUtil, KafkaUtil}

/**
  * @author hanliqiang wrote on 2018/6/12
  */
object CheckInService {
  def sendOrder(param: String): Unit = {
    val json = Json.parse(param)
    val checkInId = (json \ "CheckInInfo" \\ "CheckInID")
    var content: String = ""
    if (checkInId.isEmpty == false) {
      content = HttpUtil.doGet("CheckIn/" + checkInId.head.as[Int])
      val data = new ProducerRecord[String, String]("topic_checkin", content)
      KafkaUtil.createProducer().send(data)
      println("topic topic_checkin 发送成功")
    }
  }
}
