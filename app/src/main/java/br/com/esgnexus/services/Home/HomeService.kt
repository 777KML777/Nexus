package br.com.esgnexus.services.Home

import br.com.esgnexus.dto.HomeDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeService {
    @GET("home/{idEnterprise}")
    fun homeData(@Path("idEnterprise") enterpriseId: Int): Call<HomeDto>

}