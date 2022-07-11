package com.james.atopybook.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.james.atopybook.R
import com.james.atopybook.databinding.CheckSymptomFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckSymptomFragment : Fragment() {

    private var _binding:CheckSymptomFragmentBinding?=null
    private val binding get() = _binding!!
    private val viewModel: CheckSymptomViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.check_symptom_fragment, container, false)
        _binding = DataBindingUtil.bind(view)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}