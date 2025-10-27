package com.example.demotecnica_.data.model

/**Request body necesario para peticiones con un body JSON
 * @param id id de un usuario especifico*/
data class RequestBodyModel(
    val action: String,
    val id: Int? = null
)