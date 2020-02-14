package com.huda.historyngaliyan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FILM = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra(EXTRA_FILM) as? DataKelurahan
        supportActionBar?.title = data?.name
        tv_nama_makanan.text = data?.name
        tv_detail_makanan.text = data?.description
        iv_foto_detail?.let {
            Glide.with(this).load(data?.photo).into(it)
        }
    }
}
