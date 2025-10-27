package com.example.demotecnica_.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.demotecnica_.data.model.User

@Composable
fun SpecificUSerCard(
    modifier: Modifier = Modifier,
    user: User
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Nombre: ${user.nombre} ${user.apellido}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(text = "Edad: ${user.edad}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Dirección: ${user.direccion}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Correo: ${user.correo}", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "Tipo de usuario: ${user.tipo_usuario}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}