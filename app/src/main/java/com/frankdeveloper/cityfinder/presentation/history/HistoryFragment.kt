package com.frankdeveloper.cityfinder.presentation.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.frankdeveloper.cityfinder.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    lateinit var binding: FragmentHistoryBinding
    private val historyViewModel: HistoryViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        val recycler = binding.cityRecyclerView
        recycler.layoutManager = LinearLayoutManager(activity)
        val adapter = CityAdapter()
        pushDataToAdapter(adapter)
        adapter.setOnItemClickListener {
            historyViewModel.deleteCity(it)
        }
        recycler.adapter = adapter
        historyViewModel.getCities()

        return binding.root
    }

    private fun pushDataToAdapter(adapter: CityAdapter){
        historyViewModel.cities.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

}