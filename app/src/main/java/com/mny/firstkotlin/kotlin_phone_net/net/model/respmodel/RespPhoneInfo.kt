package com.mny.firstkotlin.kotlin_phone_net.net.model.respmodel

import android.os.Parcel
import android.os.Parcelable

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
data class RespPhoneInfo(var province:String?,var city:String?,
                         var areacode:String?,var zip:String?,
                         var company:String?,var card:String?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(province)
        parcel.writeString(city)
        parcel.writeString(areacode)
        parcel.writeString(zip)
        parcel.writeString(company)
        parcel.writeString(card)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RespPhoneInfo> {
        override fun createFromParcel(parcel: Parcel): RespPhoneInfo {
            return RespPhoneInfo(parcel)
        }

        override fun newArray(size: Int): Array<RespPhoneInfo?> {
            return arrayOfNulls(size)
        }
    }
}