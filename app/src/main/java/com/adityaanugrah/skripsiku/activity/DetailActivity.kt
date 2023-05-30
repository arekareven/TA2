@file:Suppress("DEPRECATION")

package com.adityaanugrah.skripsiku.activity

/*import kotlinx.android.synthetic.main.activity_detail.nnamaFasilitasdetail*/
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

        val koordinat = intent.getStringExtra("intent_nkoordinat")
        val latlong = koordinat!!.split(",".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        val latitude = latlong[0].toDouble()
        val longitude = latlong[1].toDouble()
        val latLng = LatLng(latitude, longitude)
//        mMap.addMarker(MarkerOptions().position(latLng).title("ini palembang"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))

        mMap.addMarker(MarkerOptions().position(latLng).title("Wisatanya"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16f))
        mMap.getUiSettings().setAllGesturesEnabled(true)
        mMap.getUiSettings().setZoomGesturesEnabled(true)
        mMap.setTrafficEnabled(true)
    }
}