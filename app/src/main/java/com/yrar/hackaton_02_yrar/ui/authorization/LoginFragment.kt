package com.yrar.hackaton_02_yrar.ui.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yrar.hackaton_02_yrar.MainActivity
import com.yrar.hackaton_02_yrar.R
import com.yrar.hackaton_02_yrar.databinding.LoginFragmentBinding
import com.yrar.hackaton_02_yrar.databinding.RegistrationFragmentBinding
import com.yrar.hackaton_02_yrar.databinding.StartAuthFragmentBinding
import com.yrar.hackaton_02_yrar.utils.AppPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

    @Inject
    lateinit var preferences: AppPreferences

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonBack.setOnClickListener {
            (requireActivity() as MainActivity).popBackstack()
        }

        binding.buttonLogin.setOnClickListener {
            preferences.writeInt(AppPreferences.CURRENT_USER_SETTING_KEY, 1)
            (requireActivity() as MainActivity).cleanFragmentManager()
            (requireActivity() as MainActivity).navigateToDefaultFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}