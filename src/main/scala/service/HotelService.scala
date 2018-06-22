package service

import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.log4j.{LogManager, Logger}
import play.api.libs.json.Json
import utils.{HttpUtil, KafkaUtil}

/**
  * @author hanliqiang wrote on 2018/6/12
  */
object HotelService {
  val LOGGER: Logger = LogManager.getLogger(getClass)

  def sendHotel(param: String): String = {
    val json = Json.parse(param)
    val hotelId = (json \ "HotelID")
    var content: String = ""
    if (hotelId.isEmpty == false) {
      content = HttpUtil.doGet("Hotel/" + hotelId.as[Int])
//      val data = new ProducerRecord[String, String]("topic_hotel", content)
//      KafkaUtil.createProducer().send(data)
      LOGGER.info("topic  topic_hotel 发送成功")
    }
    LOGGER.info("没有 HotelID")
    content
  }
}
