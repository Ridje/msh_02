package com.yrar.hackaton_02_yrar.ui.events

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
import com.yrar.hackaton_02_yrar.model.app.Event
import com.yrar.hackaton_02_yrar.ui.event.EventFragment
import com.yrar.hackaton_02_yrar.ui.user_skills.UserInterestsFragment
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
    ): View {
        _binding = EventsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).setBottomNavigationMenuVisibility(true)
        viewModel.getLiveData().observe(viewLifecycleOwner, { render(it) })
        viewModel.getActualEvents()
        binding.openUserSkills.setOnClickListener {
            (requireActivity() as MainActivity).navigateToFragment(UserInterestsFragment(), true)
        }
    }

    private fun render(state: EventsState) {
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
                binding.eventsList.adapter = EventsRecyclerViewAdapter(state.events, { event: Event ->
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}