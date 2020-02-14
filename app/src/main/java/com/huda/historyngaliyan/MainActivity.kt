package com.huda.historyngaliyan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: KelurahanAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: Array<String>
    private var daftarkel = arrayListOf<DataKelurahan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = KelurahanAdapter()
        adapter.notifyDataSetChanged()
        rv_kel.layoutManager = LinearLayoutManager(this)
        rv_kel.adapter = adapter

        prepare()
        addItem()
    }
    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.getStringArray(R.array.data_photo)
    }
    private fun addItem() {
        for (position in dataName.indices) {
            val kel = DataKelurahan(
                dataPhoto[position],
                dataName[position],
                dataDescription[position]
            )
            daftarkel.add(kel)
        }
        adapter.setData(daftarkel)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true

    }
}
