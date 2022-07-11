package com.james.atopybook.views

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.james.atopybook.utlities.CheckSymptomType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CheckSymptomViewModel @Inject constructor() : ViewModel() {

    // single livedata
    private val _backPressEvent = MutableLiveData<Void>()
    val backPressEvent :LiveData<Void> get() = _backPressEvent

    private val _onNextEvent = MutableLiveData<Void>()
    val onNextEvent:LiveData<Void> get()= _onNextEvent

    fun scoreSymptom(key:CheckSymptomType,score:Int){
        Log.d("TAG", "scoreSymptom: ${key.symptom} ${score}")
        when(key){
            CheckSymptomType.DRY ->{

            }
            CheckSymptomType.GET_RED ->{

            }
            CheckSymptomType.HURTS ->{

            }
            CheckSymptomType.ITCH ->{

            }
            else -> {
                throw IllegalArgumentException()
            }
        }
    }

    fun onBackPress(view: View){
//        _backPressEvent.value = Unit()
    }

    fun onNext(view:View){

    }
}