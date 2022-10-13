package com.brian.potterbase.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://hp-api.herokuapp.com/api/"

//Moshi converter
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//retrofit object
private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


//interface with API methods
interface PotterApiService {
    @GET("characters")
    suspend fun getAllCharacters(): MutableList<PotterCharacterItem>
}

//singleton object of Retrofit API service
object PotterApi {
    val retrofitService: PotterApiService by lazy {
        retrofit.create(PotterApiService::class.java)
    }
}

