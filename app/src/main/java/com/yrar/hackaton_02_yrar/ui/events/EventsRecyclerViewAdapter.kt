package com.yrar.hackaton_02_yrar.ui.events

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.yrar.hackaton_02_yrar.databinding.EventsFragmentItemBinding
import com.yrar.hackaton_02_yrar.model.app.Event


class EventsRecyclerViewAdapter(
    private val values: List<Event>,
    private val listener: ((event: Event) -> Unit)? = null) : RecyclerView.Adapter<EventsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(EventsFragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: EventsFragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val cardView: CardView = binding.cardView
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        fun bind(item: Event) {
            idView.text = item.id
            contentView.text = item.title
            cardView.setOnClickListener(object: View.OnClickListener {
                override fun onClick(v: View?) {
                    listener?.let {
                        listener.invoke(values[adapterPosition])
                    }
                }
            })
        }

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}