package service

import org.apache.kafka.clients.producer.ProducerRecord
import play.api.libs.json.Json
import utils.{HttpUtil, KafkaUtil}

/**
  * @author hanliqiang wrote on 2018/6/11
  */
object OrderService {
  def sendOrder(param: String): Unit = {
    val json = Json.parse(param)
    val orderId = (json \ "Order"\\"OrderID")
    var content: String = ""
    if(orderId.isEmpty == false){
      content = HttpUtil.doGet("Order/" + orderId.head.as[Int])
      val data = new ProducerRecord[String, String]("topic_order", content)
      KafkaUtil.createProducer().send(data)
      println("topic topic_order 发送成功")
    }


  }
}
