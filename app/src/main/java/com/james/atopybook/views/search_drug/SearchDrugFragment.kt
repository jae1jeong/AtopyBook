package com.james.atopybook.views.search_drug

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.james.atopybook.R
import com.james.atopybook.data.model.Drug
import com.james.atopybook.databinding.FragmentSearchDrugBinding
import com.james.atopybook.screen.SearchDrugScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchDrugFragment : Fragment() {

    private var _binding: FragmentSearchDrugBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SearchDrugViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchDrugBinding.bind(
            inflater.inflate(
                R.layout.fragment_search_drug,
                container,
                false
            )
        )

        binding.searchDrugCompose.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    SearchDrugFragmentScreen(viewModel = viewModel)
                }
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchDrugViewModel::class.java)
    }
}

@Composable
private fun SearchDrugFragmentScreen(viewModel: SearchDrugViewModel) {
    val searchResults: List<Drug> by viewModel.searchDrugItems.observeAsState(listOf())
    val lastSearchResults: List<Drug> by viewModel.lastSearchDrugItems.observeAsState(listOf())
    SearchDrugScreen(
        viewModel = viewModel,
        searchDrugResults = searchResults,
        lastSearchResults = lastSearchResults
    )
}