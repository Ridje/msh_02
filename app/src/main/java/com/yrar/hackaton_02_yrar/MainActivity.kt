package com.yrar.hackaton_02_yrar

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.yrar.hackaton_02_yrar.databinding.MainActivityBinding
import com.yrar.hackaton_02_yrar.ui.events.EventsFragment
import com.yrar.hackaton_02_yrar.ui.favourite_events.FavouriteEventsFragment
import com.yrar.hackaton_02_yrar.ui.start.StartFragment
import com.yrar.hackaton_02_yrar.ui.user_profile.UserProfileFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: MainActivityBinding? = null
    val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        _binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNavigationMenu.setOnNavigationItemSelectedListener { item -> switchNavigation(item.itemId) }

        if (savedInstanceState == null) {
            navigateToStartFragment();
        }
    }

    fun switchNavigation(itemId: Int): Boolean {
        if (binding.bottomNavigationMenu.selectedItemId.equals(itemId)) {
            return false
        }
        when (itemId) {
            R.id.navigation_home -> navigateToDefaultFragment()
            R.id.navigation_favourites -> navigateToFragment(FavouriteEventsFragment())
            R.id.navigation_user -> navigateToFragment(UserProfileFragment())
        }

        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    fun popBackstack() {
        supportFragmentManager.popBackStack()
    }

    fun setBottomNavigationMenuVisibility(visibility: Boolean) {
        when {
            visibility -> binding.bottomNavigationMenu.visibility = View.VISIBLE
            else -> binding.bottomNavigationMenu.visibility = View.GONE
        }
    }

    fun cleanFragmentManager() {
//        while (supportFragmentManager.backStackEntryCount != 0) {
//            supportFragmentManager.popBackStackImmediate()
//       }
        if (supportFragmentManager.backStackEntryCount > 0) {
            val entry: FragmentManager.BackStackEntry = supportFragmentManager.getBackStackEntryAt(0)
            supportFragmentManager.popBackStack(entry.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    fun navigateToFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    fun navigateToDefaultFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, getDefaultFragment()).commit()
        binding.bottomNavigationMenu.visibility = View.VISIBLE
    }

    fun navigateToStartFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, getStartFragment()).commit()
        binding.bottomNavigationMenu.visibility = View.GONE
    }

    fun getDefaultFragment() : Fragment {
        return EventsFragment()
    }

    fun getStartFragment() : Fragment {
        return StartFragment()
    }
}