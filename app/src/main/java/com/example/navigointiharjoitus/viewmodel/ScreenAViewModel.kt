package com.example.navigointiharjoitus.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigointiharjoitus.model.ButtonItem
import com.example.navigointiharjoitus.model.ButtonList
import kotlinx.coroutines.launch

class ScreenAViewModel : ViewModel() {
    private val _screenAState = mutableStateOf(ButtonList())
    val screenAState: State<ButtonList> =_screenAState

    init {
        getButtons()
    }
    private fun getButtons() {
        viewModelScope.launch {
            _screenAState.value = screenAState.value.copy(
                list = listOf(
                    ButtonItem(id = 1, buttonText = "Go to Screen B"),
                    ButtonItem(id = 2, buttonText = "Go to Screen C")
            ))
        }
    }
}