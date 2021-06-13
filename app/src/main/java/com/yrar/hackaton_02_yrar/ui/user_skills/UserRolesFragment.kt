package com.yrar.hackaton_02_yrar.ui.user_skills

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import com.yrar.hackaton_02_yrar.MainActivity
import com.yrar.hackaton_02_yrar.R
import com.yrar.hackaton_02_yrar.databinding.UserRolesFragmentBinding
import com.yrar.hackaton_02_yrar.databinding.UserSkillsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UserRolesFragment : Fragment() {

    private var _binding: UserRolesFragmentBinding? = null
    private val binding get() = _binding!!

    val viewModel : UserSkillsVewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = UserRolesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as MainActivity).setBottomNavigationMenuVisibility(false)
        viewModel.getLiveDataRoles().observe(viewLifecycleOwner) {
            render(it)
        }
        viewModel.getUserRoles()

        binding.nextButton.setOnClickListener {
            val adapter = binding.listInterests.adapter
            if (adapter is UserRolesAdapter) {
                viewModel.putUserRoles(adapter.selects)
            }
            (requireActivity() as MainActivity).cleanFragmentManager()
            (requireActivity() as MainActivity).navigateToDefaultFragment()
        }
    }

    fun render(state: UserRolesState) {
        when (state) {
            is UserRolesState.Error -> {}
            is UserRolesState.Success -> {

                val typeArrayImgs = resources.obtainTypedArray(R.array.roles_images)
                val listDrawable = mutableListOf<Drawable>()
                for (i in 0 until typeArrayImgs.length()) {
                    val drawable = ResourcesCompat.getDrawable(resources, typeArrayImgs.getResourceId(i, 0), context?.theme)
                    drawable?.let {
                        listDrawable.add(drawable)
                    }
                }

                binding.listInterests.setHasFixedSize(true)
                binding.listInterests.adapter = UserRolesAdapter(state.roles, listDrawable)
            }
            is UserRolesState.Loading -> {}
        }
    }
}