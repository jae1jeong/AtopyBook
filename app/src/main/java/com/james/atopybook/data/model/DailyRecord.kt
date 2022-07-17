package com.james.atopybook.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DailyRecord(
    @PrimaryKey
    val id:Long,
    val rash:Int?=null,
    val itch:Int?=null,
    val pain:Int?=null,
    val ateFoods:List<String> = emptyList(),
)
