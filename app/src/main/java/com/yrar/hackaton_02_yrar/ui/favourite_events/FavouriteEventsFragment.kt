package com.yrar.hackaton_02_yrar.ui.favourite_events

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yrar.hackaton_02_yrar.MainActivity
import com.yrar.hackaton_02_yrar.R
import com.yrar.hackaton_02_yrar.databinding.EventsFragmentBinding
import com.yrar.hackaton_02_yrar.databinding.FavouriteEventsFragmentBinding
import com.yrar.hackaton_02_yrar.model.app.Event
import com.yrar.hackaton_02_yrar.ui.event.EventFragment
import com.yrar.hackaton_02_yrar.ui.events.EventsRecyclerViewAdapter
import com.yrar.hackaton_02_yrar.ui.events.EventsState
import com.yrar.hackaton_02_yrar.ui.events.EventsViewModel
import com.yrar.hackaton_02_yrar.utils.showSnackBar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavouriteEventsFragment : Fragment() {

    private var _binding: FavouriteEventsFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FavouriteEventsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FavouriteEventsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner, { render(it) })
        viewModel.getActualFavouriteEvents()
    }

    fun render(state: FavouriteEventsState) {
        when (state) {
            is FavouriteEventsState.Loading -> {
                binding.eventsList.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE
            }
            is FavouriteEventsState.Error -> {
                binding.progressBar.visibility = View.GONE
                binding.root.showSnackBar(
                    "Error",
                    "Reload",
                    {
                        viewModel.getActualFavouriteEvents()
                    }
                )
            }
            is FavouriteEventsState.Success -> {
                binding.eventsList.adapter = FavouriteEventsRecyclerViewAdapter(state.events, { event: Event ->
                    onItemClickEvent(
                        event
                    )
                }, DateFormat.getDateFormat(context)) { event: Event ->
                    onLikeClickEvent(
                        event
                    )
                }
                binding.eventsList.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun onItemClickEvent(event: Event) {
        (requireActivity() as MainActivity).navigateToFragment(EventFragment.newInstance(event), true)
    }

    private fun onLikeClickEvent(event: Event) {
        event.isFavourite = !event.isFavourite
        viewModel.updateFavourite(event)
    }
}