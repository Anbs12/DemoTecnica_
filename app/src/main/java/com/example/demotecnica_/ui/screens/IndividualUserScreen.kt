package com.example.demotecnica_.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.demotecnica_.data.model.RequestBodyModel
import com.example.demotecnica_.data.model.User
import com.example.demotecnica_.data.retrofit.RetrofitBuilder
import com.example.demotecnica_.ui.components.SpecificUSerCard
import com.example.demotecnica_.ui.components.UserCard

/**Pantalla donde muestra solo un user especifico seleccionado
 * de MainScreen.
 * @param id Id del user recibido para cargar desde API*/
@Composable
fun IndividualUserScreen(modifier: Modifier = Modifier, id: Int) {

    //Estado de la pantalla de carga
    var isLoading by remember { mutableStateOf(true) }

    /**Data del user especifico*/
    var response by remember { mutableStateOf(User()) }

    //Para que compose escuche los cambios y actualice pantalla.
    LaunchedEffect(Unit) {
        try {
            response = RetrofitBuilder.instance.getSpecificUser(RequestBodyModel(action = "get", id = id))
            isLoading = false
        } catch (e: Exception) {
            Log.e("Errores: ", e.message.toString())
        }
    }

    if (isLoading) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Usuario unico")
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Usuario unico")
            SpecificUSerCard(user = response)
        }
    }
}