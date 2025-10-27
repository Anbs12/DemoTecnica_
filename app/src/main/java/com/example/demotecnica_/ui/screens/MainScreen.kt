package com.example.demotecnica_.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.demotecnica_.data.model.RequestBodyModel
import com.example.demotecnica_.data.model.User
import com.example.demotecnica_.data.retrofit.RetrofitBuilder
import com.example.demotecnica_.ui.components.UserCard

/**Pantalla que muestra una lista de usuarios.*/
@Composable
fun MainSscreen(modifier: Modifier = Modifier, onAction: (String) -> Unit) {

    //Datos en escucha para compose.
    var dataResult by rememberSaveable { mutableStateOf<List<User>>(emptyList()) }

    //Estado de la carga
    var isLoading by remember { mutableStateOf(true) }

    //Para que compose escuche los cambios y actualice pantalla.
    LaunchedEffect(Unit) {
        try {
            val response = RetrofitBuilder.instance.getUsers(RequestBodyModel(action = "list"))
            dataResult = response
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
            Text("Lista de Usuarios")
            CircularProgressIndicator()
        }
    } else {

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Lista de Usuarios")
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                items(dataResult) { user ->
                    UserCard(user = user) {
                        onAction(user.id!!)
                    }
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    MainSscreen() {}
}