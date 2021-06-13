package com.yrar.hackaton_02_yrar.ui.user_skills

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yrar.hackaton_02_yrar.MainActivity
import com.yrar.hackaton_02_yrar.databinding.UserSkillsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserInterestsFragment : Fragment() {

    private var _binding: UserSkillsFragmentBinding? = null
    private val binding get() = _binding!!

    val viewModel: UserSkillsVewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = UserSkillsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).setBottomNavigationMenuVisibility(false)
        viewModel.getLiveDataInterests().observe(viewLifecycleOwner) {
            render(it)
        }
        binding.nextButton.setOnClickListener {
            val adapter = binding.listInterests.adapter
            if (adapter is UserInterestsAdapter) {
                viewModel.putUserInterests(adapter.selects)
            }
            (requireActivity() as MainActivity).navigateToFragment(UserRolesFragment(), true)
        }
        viewModel.getUserInterests()
    }

    fun render(state: UserInterestsState) {

        when (state) {
            is UserInterestsState.Error -> {}
            is UserInterestsState.Success -> {
                binding.listInterests.adapter = UserInterestsAdapter(state.interests)
            }
            is UserInterestsState.Loading -> {}
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}