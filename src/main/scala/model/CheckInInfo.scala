package model

/**
  * @author hanliqiang wrote on 2018/6/11
  */
class CheckInInfo {
  var OperatorName : String = _
  var CheckInID : String = _
  var HotelID : String = _
  var UnitInstanceName : String = _
  var UnitTypeName : String = _
  var ProductName : String = _
  var SalesChannel : String = _
  var CreateTime : String = _
  var CheckInDate : String = _
  var CheckOutDate : String = _
  var OrderID : String = _
  var BillInfos : List[BillInfo] = _
  var CheckInGuestInfos : List[CheckInGuestInfo] = _
}