package model

/**
  * @author hanliqiang wrote on 2018/6/6
  */
case class WeChatModel(AppType: String, Event: String, Time: String, SessionID: String, Origin: String,
                       WxUnionID: String, WxOpenID: String, MemberID: String, HotelID: String, description: String,order: Order
                       ) {
// order: Order , checkInInfo: CheckInInfo, checkInGuestInfo: CheckInGuestInfo

  //    var AppType: String = _
  //    var Event : String = _
  //    var Time : String = _
  //    var SessionID : String = _
  //    var Origin : String = _
  //    var WxUnionID : String = _
  //    var WxOpenID : String = _
  //    var MemberID : Int = _
  //    var HotelID : Int = _
  //    var description : String = _
  //      var order : Order = _
  //    var checkInInfo : CheckInInfo = _
  //    var checkInGuestInfo : CheckInGuestInfo = _
}