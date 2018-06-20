package service

import org.apache.log4j.{LogManager, Logger}

/**
  * @author hanliqiang wrote on 2018/6/6
  */
object WeChatService {
  def getWeChatValue(param: String): String = {
    UserService.sendUser(param)
    MemberService.sendMember(param)
    OrderService.sendOrder(param)
    HotelService.sendHotel(param)
    CheckInService.sendCheckInfo(param)
    "ok"
  }
}
