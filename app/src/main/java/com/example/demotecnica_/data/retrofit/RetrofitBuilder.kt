package com.example.demotecnica_.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {

    const val BASEURL = "https://jwyyktvbjh47y4tndrcwgllhse0jlmsh.lambda-url.us-east-1.on.aws"

    /**Construye instancia retrofit con url*/
    val instance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}