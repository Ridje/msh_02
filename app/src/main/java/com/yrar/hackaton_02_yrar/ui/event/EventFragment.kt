package com.yrar.hackaton_02_yrar.ui.event

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yrar.hackaton_02_yrar.MainActivity
import com.yrar.hackaton_02_yrar.databinding.EventFragmentBinding
import com.yrar.hackaton_02_yrar.model.app.Event
import dagger.hilt.android.AndroidEntryPoint

private const val EVENT_ARGUMENT_KEY = "EVENT_OPENED"

@AndroidEntryPoint
class EventFragment : Fragment() {

    private var _binding: EventFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: EventViewModel by viewModels()

    private var event: Event? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            event = it.getParcelable(EVENT_ARGUMENT_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = EventFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (event != null) {
            renderItem()
        } else {
            (requireActivity() as MainActivity).navigateToDefaultFragment()
        }
        binding.likeIcon.setOnClickListener { onLikeClick(view) }

        (requireActivity() as MainActivity).setBottomNavigationMenuVisibility(false)
//        binding.contactEmail.setOnClickListener { onContactEmailClick(view) }
//        binding.webAddress.setOnClickListener{ onWebClick(view) }
    }

    fun onLikeClick(view: View) {
        event?.let {
            it.isFavourite = !it.isFavourite
            viewModel.updateFavourite(it)
        }
    }

    fun onWebClick(view: View) {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
//                Uri.parse(binding.webAddress.text.toString())
            )
        )
    }

    private fun onContactEmailClick(view: View) {
//        val emails = arrayOf(binding.contactEmail.text.toString())
//        val intent = Intent(Intent.ACTION_SENDTO);
//        intent.putExtra(Intent.EXTRA_EMAIL, emails);
//        intent.data = Uri.parse("mailto:" + binding.contactEmail.text.toString())
//        startActivity(intent)
    }

    @SuppressLint("SetTextI18n")
    private fun renderItem() {
        val format = DateFormat.getDateFormat(context)
        event?.apply {
            binding.title.text = title
            binding.date.text = format.format(dateStart) + if (dateEnd != null) {
                " - " + format.format(dateEnd)
            } else {
                ""
            }
            binding.fullDescription.text = fullDescription
            binding.address.text = address
            binding.likeIcon.isChecked = isFavourite
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(event: Event) =
            EventFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EVENT_ARGUMENT_KEY, event)
                }
            }
    }
}