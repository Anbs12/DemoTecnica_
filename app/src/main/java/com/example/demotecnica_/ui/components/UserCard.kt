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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demotecnica_.data.model.User

/** Card item para cada user
 * @param user datos del usuario
 * @param activate hace aparecer el button
 * @param onAction accion del button, la cual lleva a la pantalla del user unico
 */
@Composable
fun UserCard(
    modifier: Modifier = Modifier,
    user: User,
    onAction: () -> Unit
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
            Button(
                onClick = {
                    onAction()
                }
            ) {
                Text(text = "¿Mas informacion? Clic aca!")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    val user = User(
        id = "1",
        nombre = "Juan",
        apellido = "Pérez",
        edad = 28,
        direccion = "Calle 123, Madrid",
        correo = "juan.perez@email.com",
        tipo_usuario = "premium"
    )
    val da = listOf<User>(user)
    UserCard(user = user){}
}