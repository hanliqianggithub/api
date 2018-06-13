package service

/**
  * @author hanliqiang wrote on 2018/6/6
  */
object WeChatService {
  def getWeChatValue(param: String): Unit = {
    UserService.sendUser(param)
    MemberService.sendMember(param)
    OrderService.sendOrder(param)
    HotelService.sendHotel(param)
    CheckInService.sendOrder(param)
  }
}
