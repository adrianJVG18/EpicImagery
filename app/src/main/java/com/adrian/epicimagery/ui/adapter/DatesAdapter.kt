package com.adrian.epicimagery.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.adrian.epicimagery.databinding.ItemDateBinding
import com.adrian.epicimagery.domain.model.dto.DateDto

@SuppressLint("NotifyDataSetChanged")
class DatesAdapter(
    private var dateList: List<DateDto>
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var dates: List<DateDto> = ArrayList()

    fun updateList(list: List<DateDto>) {
        dates = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DateViewHolder).bind(dates[position])
    }

    override fun getItemCount(): Int = dates.size


    private inner class DateViewHolder(
        private val binding: ItemDateBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DateDto) {
            binding.dateTextview.text = item.date
        }
    }
}
