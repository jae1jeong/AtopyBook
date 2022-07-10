package com.james.atopybook.views

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.james.atopybook.R
import com.james.atopybook.databinding.FragmentRecordBinding
import com.james.atopybook.views.calendar.CalendarAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecordFragment : Fragment(R.layout.fragment_record) {
    private var _binding: FragmentRecordBinding? = null
    private val binding get() = _binding!!
    private val recordViewModel by viewModels<RecordViewModel>()
    private lateinit var calendarAdapter: CalendarAdapter

//    private lateinit var viewModel: RecordViewModel

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() {
        recordViewModel.currentDate.observe(viewLifecycleOwner,{
            binding.recordTvTodayDate.text = it.toString("MM")
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}