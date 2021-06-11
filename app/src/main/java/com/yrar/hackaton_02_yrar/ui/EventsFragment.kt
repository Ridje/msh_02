package com.yrar.hackaton_02_yrar.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yrar.hackaton_02_yrar.databinding.EventsFragmentBinding
import com.yrar.hackaton_02_yrar.utils.showSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventsFragment : Fragment() {

    private var _binding: EventsFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: EventsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EventsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner, { render(it)})
        viewModel.getActualEvents()
    }

    fun render(state: EventsState) {
        when (state) {
            is EventsState.Loading -> {
                binding.eventsList.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE
            }
            is EventsState.Error -> {
                binding.progressBar.visibility = View.GONE
                binding.root.showSnackBar(
                    "Error",
                    "Reload",
                    {
                        viewModel.getActualEvents()
                    }
                )
            }
            is EventsState.Success -> {
                binding.eventsList.adapter = EventsRecyclerViewAdapter(state.events)
                binding.eventsList.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}