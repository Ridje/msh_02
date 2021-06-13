package com.yrar.hackaton_02_yrar.ui.user_skills

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yrar.hackaton_02_yrar.databinding.UserSkillsFragmentInterestsHeaderBinding
import com.yrar.hackaton_02_yrar.databinding.UserSkillsFragmentItemBinding
import com.yrar.hackaton_02_yrar.model.app.Event
import com.yrar.hackaton_02_yrar.model.app.Interest
import java.text.DateFormat

class UserInterestsAdapter(
    val selects: MutableMap<Interest, Boolean>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val values = selects.keys.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            return HeaderViewHolder(UserSkillsFragmentInterestsHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else {
            return ItemViewHolder(UserSkillsFragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> holder.bind(values[position - 1])
        }
    }

    override fun getItemViewType(position: Int): Int {
        if ( position == 0 ) {
            //header
            return 0
        } else (
            //item
            return 1
        )
    }

    override fun getItemCount(): Int {
        return 1 + values.size
    }

    inner class HeaderViewHolder(val binding: UserSkillsFragmentInterestsHeaderBinding) : RecyclerView.ViewHolder(binding.root)

    inner class ItemViewHolder(val binding: UserSkillsFragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {

        lateinit var interest: Interest

        init {
            binding.interestSelected.setOnCheckedChangeListener {
                _, value ->
                interest.let { selects[interest] = value}
            }
        }

        fun bind(interest: Interest) {
            this.interest = interest
            binding.interest.text = interest.title.replaceFirstChar { it -> it.uppercase() }
            binding.interestSelected.isChecked = (selects[interest] == true)
        }
    }

}