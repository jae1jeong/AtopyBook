package com.james.atopybook.views.record

import android.util.Log
import android.view.View
import androidx.lifecycle.*
import com.james.atopybook.utlities.liveData.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import org.joda.time.DateTime
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor(): ViewModel() {
    private val dateTimeFormatter = SimpleDateFormat("MM.dd",Locale.getDefault())
    val todayDateFormat = dateTimeFormatter.format(Date())

    private val _previousCalendarEvent = SingleLiveEvent<Void>()
    val previousCalendarEvent:LiveData<Void> get() = _previousCalendarEvent

    private val _nextCalendarEvent = SingleLiveEvent<Void>()
    val nextCalendarEvent:LiveData<Void> get() = _nextCalendarEvent

    private val _currentDateTime = MutableLiveData(DateTime.now())

    val currentMonth :LiveData<String> = _currentDateTime.asFlow().map {
        "${_currentDateTime.value!!.monthOfYear}월"
    }.asLiveData()




    fun onLeftBtnClick(view: View){
        _previousCalendarEvent.call()
        _currentDateTime.value = _currentDateTime.value?.minusMonths(1)
    }

    fun onRightBtnClick(view: View){
        _nextCalendarEvent.call()
        _currentDateTime.value = _currentDateTime.value?.plusMonths(1)
    }

}