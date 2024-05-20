package com.zeynepdogru.cryptoapp.model


data class Crypto(
    val id:String,
    val symbol:String,
    val name:String,
    val nameid:String,
    val rank:Int,
    val price_usd:String,
    val percent_change_24h:String,
    val percent_change_1h:String,
    val percent_change_7d:String,
    val price_btc:String,
    val market_cap_usd:String,
    val volume24:Double,
    val volume24a:Double,
    val csupply:String,
    val tsupply:String,
    val msupply:String

)


//    val id: Int,
//    @SerializedName("title")
//    val title: String,
//    val price: String,
//    val description: String,
//    val category: String,
//    @SerializedName("image")
//    val productImage: String,
//    val rating: Rating // Rating sınıfını buraya dahil ediyoruz
//)

//data class Rating(
//    val rate: Double,
//    val count: Int
//)

//{
//    "id": "46968",
//    "symbol": "FRAX",
//    "name": "Frax",
//    "nameid": "frax",
//    "rank": 101,
//    "price_usd": "0.997055",
//    "percent_change_24h": "0.02",
//    "percent_change_1h": "0.00",
//    "percent_change_7d": "0.05",
//    "price_btc": "0.000015",
//    "market_cap_usd": "647549394.95",
//    "volume24": 2960669.54311165,
//    "volume24a": 2879301.40989941,
//    "csupply": "649462235.00",
//    "tsupply": "1044853133.2588",
//    "msupply": ""
//},