package com.james.atopybook.views

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.james.atopybook.R
import com.james.atopybook.databinding.FragmentRecordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecordFragment : Fragment(R.layout.fragment_record) {
    private var _binding:FragmentRecordBinding?=null
    private val binding get() = _binding!!
    private val recordViewModel by viewModels<RecordViewModel>()

    private lateinit var viewModel: RecordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_record, container, false)
    }

    private fun observeData(){

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}