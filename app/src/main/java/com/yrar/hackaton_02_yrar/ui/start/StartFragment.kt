package com.yrar.hackaton_02_yrar.ui.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.yrar.hackaton_02_yrar.MainActivity
import com.yrar.hackaton_02_yrar.R
import com.yrar.hackaton_02_yrar.ui.authorization.StartAuthFragment
import com.yrar.hackaton_02_yrar.utils.AppPreferences
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class StartFragment : Fragment() {

    @Inject
    lateinit var preferences: AppPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.start_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        if (preferences.readInt(AppPreferences.CURRENT_USER_SETTING_KEY) == 0) {
            (requireActivity() as MainActivity).navigateToFragment(StartAuthFragment())
            (requireActivity() as MainActivity).setBottomNavigationMenuVisibility(false)
        } else {
            lifecycleScope.launch(Dispatchers.IO) {
                delay(3000L)
                withContext(Dispatchers.Main) {
                    (requireActivity() as MainActivity).navigateToDefaultFragment()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).setBottomNavigationMenuVisibility(false)
        view.setOnClickListener {
            (requireActivity() as MainActivity).navigateToDefaultFragment()
        }
    }
}