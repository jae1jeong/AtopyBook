package com.james.atopybook.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.james.atopybook.R
import com.james.atopybook.databinding.FragmentRecordBinding
import com.james.atopybook.views.calendar.CalendarAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecordFragment : Fragment(R.layout.fragment_record) {
    private var _binding: FragmentRecordBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<RecordViewModel>()
    private lateinit var calendarAdapter: CalendarAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_record, container, false)
        calendarAdapter = CalendarAdapter(childFragmentManager,lifecycle)
        binding.recordVp2Calendar.apply {
            adapter = calendarAdapter
            setCurrentItem(CalendarAdapter.START_POSITION,false)
        }
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() {

    }

    override fun onResume() {
        super.onResume()
        moveToCheckSymptom()
    }

    private fun moveToCheckSymptom(){
        val action = RecordFragmentDirections.actionRecordFragmentToCheckSymptomFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}