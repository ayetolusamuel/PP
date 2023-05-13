package com.pedektech.pricepally.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedektech.pricepally.R
import com.pedektech.pricepally.model.Data

class TeachersAdapter(private var datas: List<Data>) :
    RecyclerView.Adapter<TeachersAdapter.DataViewHolder>() {

    class DataViewHolder(
        itemView: View,
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(data:Data) {
            itemView.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.teacher_item, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val setting = datas[position]
        holder.bind(setting)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

}
