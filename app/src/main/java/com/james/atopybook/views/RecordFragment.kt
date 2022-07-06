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
        calendarAdapter = CalendarAdapter(requireActivity())
        binding.recordVp2Calendar.apply {
            adapter = calendarAdapter
            setCurrentItem(CalendarAdapter.START_POSITION,false)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    // viewPager
                    val view = (binding.recordVp2Calendar[0] as RecyclerView).layoutManager?.findViewByPosition(position)
                    view?.post {
                        val wMeasureSpec =
                            View.MeasureSpec.makeMeasureSpec(view.width, View.MeasureSpec.EXACTLY)
                        val hMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
                        view.measure(wMeasureSpec, hMeasureSpec)
                        if (binding.recordVp2Calendar.layoutParams.height != view.measuredHeight) {
                            binding.recordVp2Calendar.layoutParams = (binding.recordVp2Calendar.layoutParams).also { lp ->
                                lp.height = view.measuredHeight
                            }
                        }
                    }
                }
            })
        }
        return binding.root
    }

    private fun observeData() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}