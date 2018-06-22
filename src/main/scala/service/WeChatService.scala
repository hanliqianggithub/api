package service

import org.apache.kafka.clients.producer.ProducerRecord
import play.api.libs.json.{JsObject, Json}
import utils.KafkaUtil

/**
  * @author hanliqiang wrote on 2018/6/6
  */
object WeChatService {
  def getWeChatValue(param: String): String = {
    val json = Json.parse(param)
    val user = UserService.sendUser(param)
    val member = MemberService.sendMember(param)
    val order = OrderService.sendOrder(param)
    val hotel = HotelService.sendHotel(param)
    val checkin = CheckInService.sendCheckInfo(param)
    var userVal: AnyRef = new AnyRef
    if (user != "") {
      val jsVal = Json.parse(user)
      userVal = json.as[JsObject] ++ Json.obj("WxUser" -> jsVal)
    }
    var memberVal: AnyRef = new AnyRef
    if (member != "") {
      val jsVal = Json.parse(member)
      memberVal = userVal.asInstanceOf[JsObject] ++ Json.obj("Member" -> jsVal)
    } else {
      memberVal = userVal
    }
    var orderVal: AnyRef = new AnyRef
    if (order != "") {
      val jsVal = Json.parse(order)
      orderVal = memberVal.asInstanceOf[JsObject] ++ Json.obj("Order" -> jsVal)
    } else {
      orderVal = memberVal
    }
    //
    var hotelVal: AnyRef = new AnyRef
    if (hotel != "") {
      val jsVal = Json.parse(hotel)
      hotelVal = orderVal.asInstanceOf[JsObject] ++ Json.obj("Hotel" -> jsVal)
    } else {
      hotelVal = orderVal
    }
    var checkVal: AnyRef = new AnyRef
    if (checkin != "") {
      val jsVal = Json.parse(checkin)
      checkVal = orderVal.asInstanceOf[JsObject] ++ Json.obj("CheckIn" -> jsVal)
    } else {
      checkVal = hotelVal
    }
//    val data = new ProducerRecord[String, String]("topic_swd", checkVal.toString)
//    KafkaUtil.createProducer().send(data)
    "ok"
  }
}
