package com.example.navdrawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp

@Composable
fun Favorite(onClick: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .clickable { onClick() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
        Text(text = "Favorite", fontSize = 32.sp)
    }
}


@Composable
fun Face(onClick: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .clickable { onClick() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(imageVector = Icons.Default.Face, contentDescription = "Face")
        Text(text = "Face", fontSize = 32.sp)
    }
}

@Composable
fun Email(onClick: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .clickable { onClick() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
        Text(text = "Email", fontSize = 32.sp)
    }
}

