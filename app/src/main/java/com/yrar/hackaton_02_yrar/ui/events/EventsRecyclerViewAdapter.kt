package com.yrar.hackaton_02_yrar.ui.events

import android.annotation.SuppressLint
import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yrar.hackaton_02_yrar.databinding.EventsFragmentItemBinding
import com.yrar.hackaton_02_yrar.model.app.Event
import java.text.DateFormat


class EventsRecyclerViewAdapter(
    private val values: List<Event>,
    private val listener: ((event: Event) -> Unit)? = null,
    private val dateFormat: DateFormat,
    private val listenerOnLikeClick: ((event: Event) -> Unit)? = null
) : RecyclerView.Adapter<EventsRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(EventsFragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val binding: EventsFragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {

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

        @SuppressLint("SetTextI18n")
        fun bind(item: Event) {

            binding.title.text = item.title
            binding.description.text = item.description
            binding.date.text = dateFormat.format(item.dateStart) + if (item.dateEnd != null) {
                " - " + dateFormat.format(item.dateEnd)
            } else {
                ""
            }
            binding.address.text = item.address
            binding.likeIcon.isChecked = item.isFavourite

        }

    }

    class SimpleDividerItemDecorationLastExcluded(private val spacing: Float) :
        RecyclerView.ItemDecoration() {

        override fun getItemOffsets(
            rect: Rect,
            view: View,
            parent: RecyclerView,
            s: RecyclerView.State
        ) {
            parent.adapter?.let { adapter ->
                rect.bottom = when (parent.getChildAdapterPosition(view)) {
                    RecyclerView.NO_POSITION, adapter.itemCount - 1 -> 0
                    else -> spacing.toInt()
                }
            }
        }

    }

}