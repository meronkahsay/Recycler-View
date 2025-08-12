package com.gorzo.recyclerview

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//retrofit is library that helps for http request to make our api call
//to convert to json json data to kotlin object gson convertor factory
//we may have different api
//buildApiClient( takes a file
object ApiClient {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(
            GsonConverterFactory.create()).build()

    fun <T> buildApiClient(apiInterface: Class<T>):T{
        return retrofit.create(apiInterface)
    }
}
