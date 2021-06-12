package com.yrar.hackaton_02_yrar.ui.authorization


import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yrar.hackaton_02_yrar.MainActivity
import com.yrar.hackaton_02_yrar.databinding.StartAuthFragmentBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartAuthFragment : Fragment() {

    private var _binding: StartAuthFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = StartAuthFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).setBottomNavigationMenuVisibility(false)
        binding.registration.setOnClickListener {
            (requireActivity() as MainActivity).navigateToFragment(RegistrationFragment(), true)
        }
        binding.buttonLogin.setOnClickListener {
            (requireActivity() as MainActivity).navigateToFragment(LoginFragment(), true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}