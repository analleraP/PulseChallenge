package com.allerap.android.pulsechallenge.data.remote

import com.allerap.android.pulsechallenge.data.entities.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/test/native/contentList.json")
    fun getItems(): Call<List<Item>>

    @GET("/test/native/content/{id}.json")
    fun getItem(@Path("id") id: Int): Call<Item>
}