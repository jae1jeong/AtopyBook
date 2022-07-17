package com.james.atopybook.data.model

data class Drug(
    val name: String,
    val perDay: Int,
    val drugType: DrugType,
    var isSelected: Boolean = false
)

sealed class DrugType(val name:String) {
    class Medication() : DrugType(name = "복용약")
}
