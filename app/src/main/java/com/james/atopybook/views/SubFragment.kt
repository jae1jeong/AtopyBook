package com.james.atopybook.views

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.james.atopybook.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubFragment : Fragment(R.layout.fragment_sub) {

    companion object {
        fun newInstance() = SubFragment()
    }

    private lateinit var viewModel: SubViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sub, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SubViewModel::class.java)
        // TODO: Use the ViewModel
    }

}