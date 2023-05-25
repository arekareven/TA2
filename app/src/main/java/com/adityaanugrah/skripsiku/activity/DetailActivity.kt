@file:Suppress("DEPRECATION")

package com.adityaanugrah.skripsiku.activity

import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adityaanugrah.skripsiku.R
import com.adityaanugrah.skripsiku.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_detail.nalamatdetail
import kotlinx.android.synthetic.main.activity_detail.ndeskrispsidetail
import kotlinx.android.synthetic.main.activity_detail.ngambar
/*import kotlinx.android.synthetic.main.activity_detail.nnamaFasilitasdetail*/
import kotlinx.android.synthetic.main.activity_detail.nnamaWisatadetail

class DetailActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap : GoogleMap
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

//        setContentView(R.layout.activity_detail)
        nnamaWisatadetail.text = intent.getStringExtra("intent_nnamaWisata")
        nalamatdetail.text = intent.getStringExtra("intent_nalamat")
        ndeskrispsidetail.text = intent.getStringExtra("intent_ndeskripsi")

        Glide.with(this)
            .load(intent.getStringExtra("intent_ngambar"))
            .placeholder(R.drawable.ic_launcher_background)
            .error(androidx.appcompat.R.drawable.abc_ratingbar_indicator_material)
            .centerCrop()
            .into(ngambar)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val palembang = LatLng(-2.9765658625421154, 104.7694819886803)
        mMap.addMarker(MarkerOptions().position(palembang).title("ini palembang"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(palembang))
    }
}