package service

import org.apache.kafka.clients.producer.ProducerRecord
import play.api.libs.json.Json
import utils.{HttpUtil, KafkaUtil}

/**
  * @author hanliqiang wrote on 2018/6/11
  */
object MemberService {

  def sendMember(param :String): Unit  = {
    val json = Json.parse(param)
    val memberId = (json \ "MemberID")
    var content: String = ""
    if(memberId.isEmpty == false){
      content = HttpUtil.doGet("Member/"+memberId.as[Int])
      val data = new ProducerRecord[String,String]("topic_member",content)
      KafkaUtil.createProducer().send(data)
      println("topic  topic_member 发送成功")
    }
  }
}
