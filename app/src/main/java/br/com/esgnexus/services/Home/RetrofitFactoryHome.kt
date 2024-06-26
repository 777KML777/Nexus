package br.com.esgnexus.services.Home

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactoryHome {
    // private val URL_BASE = "https://nexus-api-henna.vercel.app/"
    // private val URL_BASE = "http://192.168.1.3:3333/"
    private val URL_BASE = "https://gnexus-api-develop.onrender.com/"
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun homeServiceGetHomeData() : HomeService {
        return retrofitFactory.create(HomeService:: class.java)
    }

}