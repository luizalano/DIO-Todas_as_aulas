package br.com.luigipietro.usandapi.api

import br.com.luigipietro.usandapi.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {
    @GET("getdata.php")
    fun getProductApi(): Call<List<Product>>
}