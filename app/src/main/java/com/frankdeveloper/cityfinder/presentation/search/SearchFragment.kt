package com.frankdeveloper.cityfinder.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import com.frankdeveloper.cityfinder.R
import com.frankdeveloper.cityfinder.databinding.FragmentSearchBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(), OnMapReadyCallback {

    lateinit var binding: FragmentSearchBinding
    private val searchViewModel: SearchViewModel by viewModels()
    private var googleMap : GoogleMap? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        createMapFragment()
        searchAction()

        observeData()

        return binding.root

    }

    private fun observeData(){

        searchViewModel.isLoading.observe(viewLifecycleOwner){
            if (it){
                binding.cardCityInfo.visibility = View.VISIBLE
                binding.textCityName.visibility = View.GONE
                binding.textLatLng.visibility = View.GONE
                binding.textLocalTime.visibility = View.GONE
                binding.textCondition.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE
            }else{
                binding.textCityName.visibility = View.VISIBLE
                binding.textLatLng.visibility = View.VISIBLE
                binding.textLocalTime.visibility = View.VISIBLE
                binding.textCondition.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
            }
        }
        searchViewModel.city.observe(viewLifecycleOwner){ it ->
            val latLng = LatLng(it.lat, it.lng)
            googleMap?.let {
                it.clear()
                it.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14f))
                it.addMarker(MarkerOptions().position(latLng))
            }
            binding.textCityName.apply {
                text = it.city
            }

            binding.textLatLng.apply {
                val latLong = "Lat: ${it.lat} - Lng: ${it.lng}"
                text = latLong
            }

            binding.textLocalTime.apply {
                val localTime = "Fecha local: ${it.localTime}"
                text = localTime
            }

            binding.textCondition.apply {
                val condition = "Clima local: ${it.condition}"
                text = condition
            }

        }
    }

    private fun searchAction() {
        binding.searchSV.setOnQueryTextListener(object : OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    searchViewModel.searchCity(query)

                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }
        })

    }

    private fun createMapFragment() {
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(mGoogleMap: GoogleMap) {
        mGoogleMap.uiSettings.isZoomControlsEnabled = true
        googleMap = mGoogleMap
    }

}