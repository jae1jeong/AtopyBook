package com.james.atopybook.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.joda.time.DateTime
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor(): ViewModel() {
    // TODO: Implement the ViewModel
    val currentDate =  MutableLiveData<DateTime>()
}