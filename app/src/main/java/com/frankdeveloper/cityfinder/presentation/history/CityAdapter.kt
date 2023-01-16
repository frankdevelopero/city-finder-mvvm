package com.frankdeveloper.cityfinder.presentation.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.frankdeveloper.cityfinder.databinding.ItemCityFinderBinding
import com.frankdeveloper.cityfinder.domain.model.City

class CityAdapter : ListAdapter<City, CityAdapter.CityViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<City>() {
        override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem.id == newItem.id
        }
    }

    private var onItemClickListener: ((City) -> Unit)? = null
    fun setOnItemClickListener(onItemClickListener: (City) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapter.CityViewHolder {
        val binding = ItemCityFinderBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = getItem(position)
        holder.bind(city)
    }

    inner class CityViewHolder(private val binding: ItemCityFinderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cityModel: City) {
            binding.textCityId.text = cityModel.id.toString()
            binding.textCityName.text = cityModel.city
            binding.imgCityDelete.setOnClickListener {
                onItemClickListener?.invoke(cityModel)
            }
        }
    }
}