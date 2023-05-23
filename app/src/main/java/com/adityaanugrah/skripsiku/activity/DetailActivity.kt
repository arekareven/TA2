@file:Suppress("DEPRECATION")

package com.adityaanugrah.skripsiku.activity

import androidx.activity.ComponentActivity
import android.os.Bundle
import com.adityaanugrah.skripsiku.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.nalamatdetail
import kotlinx.android.synthetic.main.activity_detail.ndeskrispsidetail
import kotlinx.android.synthetic.main.activity_detail.ngambar
/*import kotlinx.android.synthetic.main.activity_detail.nnamaFasilitasdetail*/
import kotlinx.android.synthetic.main.activity_detail.nnamaWisatadetail

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
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
}