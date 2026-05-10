package com.aero.antypattern.ui.antipattern

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aero.antypattern.domain.User

@Composable
fun StatePerItemScreen() {
    var users by remember {
        mutableStateOf(List(1000) { User(it, "User$it") })
        }
    Column (modifier = Modifier.padding(16.dp).safeDrawingPadding()) {
        Button(onClick = {
            users = users + User(users.size, "Nuevo Usuario")
        }) {
            Text("Agregar usuario")
        }
        LazyColumn {
            items(
                items = users,
                key = { it.id }
            ) { user ->
                UserItem(user)
            }
        }
    }
}

@Composable
fun UserItem(user: User) {
    var expanded by remember {
        mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
            .padding(16.dp)
    ) {
        Text(user.name)
        if (expanded) {
            Text("Detalles del usuario ${user.id}")
        }
    }
}