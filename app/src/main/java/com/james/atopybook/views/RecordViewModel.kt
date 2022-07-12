package com.james.atopybook.views

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.james.atopybook.utlities.liveData.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import org.joda.time.DateTime
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor(): ViewModel() {
    // TODO: Implement the ViewModel
    val currentDate =  MutableLiveData<DateTime>()
    private val dateTimeFormatter = SimpleDateFormat("MM.dd",Locale.getDefault())
    val todayDateFormat = dateTimeFormatter.format(Date())

    private val _previousCalendarEvent = SingleLiveEvent<Void>()
    val previousCalendarEvent:LiveData<Void> get() = _previousCalendarEvent

    private val _nextCalendarEvent = SingleLiveEvent<Void>()
    val nextCalendarEvent:LiveData<Void> get() = _nextCalendarEvent


    fun onLeftBtnClick(view: View){
        _previousCalendarEvent.call()
    }

    fun onRightBtnClick(view: View){
        _nextCalendarEvent.call()
    }

}