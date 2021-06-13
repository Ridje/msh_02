package com.yrar.hackaton_02_yrar.ui.user_skills

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yrar.hackaton_02_yrar.databinding.UserRolesFragmentItemBinding

import com.yrar.hackaton_02_yrar.model.app.Role
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.selects.select
import javax.inject.Inject

class UserRolesAdapter(val selects: MutableMap<Role, Boolean>, val listRoleImages: List<Drawable>): RecyclerView.Adapter<UserRolesAdapter.viewHolder>() {

    private val values = selects.keys.toList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(UserRolesFragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int = values.size

    inner class viewHolder(val binding: UserRolesFragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {


        init {
            binding.cardView.setOnClickListener {
                val currentRole = values[adapterPosition]
                val currentValueSelected = selects[currentRole] ?: false
                selects[currentRole] = !currentValueSelected
                notifyDataSetChanged()
            }
        }
        fun bind(role: Role) {
            binding.title.text = role.title
            binding.imageContainer.setImageDrawable(listRoleImages[role.id - 1])
            binding.cardView.cardElevation = when { selects[role] == true -> 10f else -> 0f }
        }
    }
}