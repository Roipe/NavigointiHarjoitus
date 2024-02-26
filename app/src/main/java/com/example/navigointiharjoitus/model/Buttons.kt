package com.example.navigointiharjoitus.model

data class ButtonList(val list: List<ButtonItem> = emptyList())

data class ButtonItem(val id: Int = 0, val buttonText: String = "")