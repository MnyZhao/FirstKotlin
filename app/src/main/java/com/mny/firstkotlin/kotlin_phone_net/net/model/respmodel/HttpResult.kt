package com.mny.firstkotlin.kotlin_phone_net.net.model.respmodel

//{
//"resultcode":"200",
//"reason":"Return Successd!",
//"result":{
//    "province":"浙江",
//    "city":"杭州",
//    "areacode":"0571",
//    "zip":"310000",
//    "company":"中国移动",
//    "card":""
//}
//}
data class HttpResult<T>(val resultcode: String, val reason: String, val result: T)