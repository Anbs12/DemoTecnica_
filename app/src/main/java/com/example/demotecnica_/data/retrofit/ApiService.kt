package com.example.demotecnica_.data.retrofit

import com.example.demotecnica_.data.model.RequestBodyModel
import com.example.demotecnica_.data.model.User
import retrofit2.http.Body
import retrofit2.http.POST

/**Metodos de la api*/
interface ApiService {

    /**Devuelve la lista de los usuarios*/
    @POST("usuarios")
    suspend fun getUsers(@Body body: RequestBodyModel): List<User>

    /**Devuelve un unico usuario dado su ID*/
    @POST("usuario")
    suspend fun getSpecificUser(@Body body: RequestBodyModel): User
}