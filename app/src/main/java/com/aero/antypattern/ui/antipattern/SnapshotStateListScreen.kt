package com.aero.antypattern.ui.antipattern

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aero.antypattern.domain.User

@Composable
fun SnapshotStateListScreen() {
    val users = remember {
        mutableStateListOf<User>().apply {
            addAll(List(1000) { User(it, "User $it") })
        }
    }
    Column (modifier = Modifier.padding(16.dp).safeDrawingPadding()) {
        Button(onClick = {
            users.add(User(users.size, "Nuevo Usuario"))
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