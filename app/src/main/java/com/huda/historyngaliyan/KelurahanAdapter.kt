package com.huda.historyngaliyan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_kel.view.*

class KelurahanAdapter : RecyclerView.Adapter<KelurahanAdapter.ListViewHolder>() {

    var dataKelurahan = arrayListOf<DataKelurahan>()
    fun setData(kel: List<DataKelurahan>) {
        this.dataKelurahan = kel as ArrayList<DataKelurahan>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_kel, viewGroup, false)
        return ListViewHolder(view)    }

    override fun getItemCount(): Int = dataKelurahan.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(dataKelurahan[position])
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(kel: DataKelurahan) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(kel.photo)
                    .apply(RequestOptions().override(512, 512))
                    .into(img_item_photo)
                tv_item_name.text = kel.name
                tv_item_description.text = kel.description
                cd_detail.setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, kel)
                    ContextCompat.startActivity(context, intent, Bundle())
                }
            }
        }
    }
}