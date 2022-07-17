package com.james.atopybook.views.search_drug

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.james.atopybook.data.model.Drug
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchDrugViewModel @Inject constructor() : ViewModel() {

    private var _searchDrugItems = MutableLiveData(listOf<Drug>())
    val searchDrugItems:LiveData<List<Drug>> = _searchDrugItems

    private var _lastSearchDrugItems = MutableLiveData(listOf<Drug>())
    val lastSearchDrugItems:LiveData<List<Drug>> = _lastSearchDrugItems

    private var _words = MutableLiveData("")
    val words:LiveData<String> get() = _words
}