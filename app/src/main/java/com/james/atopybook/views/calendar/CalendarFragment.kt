package com.james.atopybook.views.calendar

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.james.atopybook.R
import com.james.atopybook.databinding.FragmentCalendarBinding
import com.james.atopybook.utlities.CalendarUtils.Companion.getMonthList
import com.james.atopybook.views.CalendarViewModel
import com.james.atopybook.views.RecordViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.joda.time.DateTime

@AndroidEntryPoint
class CalendarFragment : Fragment() {

    private var millis:Long = 0L
    private var _binding:FragmentCalendarBinding?=null
    private val binding get() = _binding!!

    private val viewModel: RecordViewModel by viewModels(
        ownerProducer = { requireParentFragment() }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            millis = it.getLong(MILLIS)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_calendar, container, false)

        _binding = FragmentCalendarBinding.bind(view)
//        binding.calendarViewTvDate.text = DateTime(millis).toString("yyyy-MM")
        viewModel.currentDate.value = DateTime(millis)
        binding.calendarView.initCalendar(DateTime(millis),getMonthList(DateTime(millis)))
        return binding.root
    }



    companion object {

        private const val MILLIS = "MILLIS"

        fun newInstance(millis: Long) = CalendarFragment().apply {
            arguments = Bundle().apply {
                putLong(MILLIS, millis)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}