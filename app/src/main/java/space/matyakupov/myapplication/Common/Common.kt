package space.matyakupov.myapplication.Common

import space.matyakupov.myapplication.Interface.RetrofitServices
import space.matyakupov.myapplication.Retrofit.RetrofitClient

object Common {
    private val BASE_URL: String = "https://www.simplifiedcoding.net/demos/"
    val retrofitService: RetrofitServices
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)

}