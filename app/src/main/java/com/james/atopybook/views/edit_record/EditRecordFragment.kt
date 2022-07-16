package com.james.atopybook.views.edit_record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.james.atopybook.R
import com.james.atopybook.screen.EditRecordScreen
import com.james.atopybook.databinding.FragmentEditRecordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditRecordFragment : Fragment() {
    private var _binding: FragmentEditRecordBinding? = null
    private val binding get() = _binding!!

    private val viewModel: EditRecordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditRecordBinding.inflate(inflater, container, false)
        binding.editRecordComposeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme{
                    EditRecordScreen(title = getString(R.string.how_was_today), subTitle =getString(R.string.please_record_compared_yesterday), nextBtnOnClick = {} ) {
                        requireActivity().onBackPressed()
                    }
                }
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}