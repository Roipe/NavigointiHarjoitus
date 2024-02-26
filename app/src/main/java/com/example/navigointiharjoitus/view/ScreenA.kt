package com.example.navigointiharjoitus.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.navigointiharjoitus.viewmodel.ScreenAViewModel

@Composable
fun ScreenA(goToScreenB: () -> Unit, goToScreenC: () -> Unit) {
    val screenAVm: ScreenAViewModel = viewModel()
    Text(
        text = "Screen A",
        style = MaterialTheme.typography.headlineLarge,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(10.dp)
    )
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(screenAVm.screenAState.value.list) {
            Button(onClick = {
                when (it.id) {
                    1 -> goToScreenB()
                    2 -> goToScreenC()
                }
            }) {
                Text(it.buttonText)
            }
        }
    }
}