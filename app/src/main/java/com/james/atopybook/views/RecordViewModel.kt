package com.james.atopybook.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.joda.time.DateTime
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor(): ViewModel() {
    // TODO: Implement the ViewModel
    val currentDate =  MutableLiveData<DateTime>()
    private val dateTimeFormatter = SimpleDateFormat("MM.dd",Locale.getDefault())
    val todayDateFormat = dateTimeFormatter.format(Date())


}