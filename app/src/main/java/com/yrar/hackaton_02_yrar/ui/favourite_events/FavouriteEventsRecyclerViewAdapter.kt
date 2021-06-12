package com.yrar.hackaton_02_yrar.ui.favourite_events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yrar.hackaton_02_yrar.databinding.FavouriteEventsFragmentItemBinding
import com.yrar.hackaton_02_yrar.model.app.Event
import java.text.DateFormat

class FavouriteEventsRecyclerViewAdapter(
    private val values: List<Event>,
    private val listener: ((event: Event) -> Unit)? = null,
    private val dateFormat: DateFormat,
    private val listenerOnLikeClick: ((event: Event) -> Unit)? = null
): RecyclerView.Adapter<FavouriteEventsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteEventsRecyclerViewAdapter.ViewHolder {
        return ViewHolder(FavouriteEventsFragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FavouriteEventsRecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int = values.size


    inner class ViewHolder(val binding: FavouriteEventsFragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.cardView.setOnClickListener {
                listener?.let {
                    listener.invoke(values[adapterPosition])
                }
            }
            binding.likeIcon.setOnClickListener {
                listenerOnLikeClick?.let {
                    listenerOnLikeClick.invoke(values[adapterPosition])
                }
            }
        }

        fun bind(item: Event) {
            binding.title.text = item.title
            binding.likeIcon.isChecked = item.isFavourite
        }

    }
}