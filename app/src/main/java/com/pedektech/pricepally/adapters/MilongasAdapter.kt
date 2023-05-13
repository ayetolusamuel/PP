package com.pedektech.pricepally.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pedektech.pricepally.R
import com.pedektech.pricepally.model.Data

/**

Adapter class for displaying a list of Data objects in a RecyclerView.

@param datas The list of Data objects to display.
 */
class MilongasAdapter(private val datas: List<Data>) :
    RecyclerView.Adapter<MilongasAdapter.DataViewHolder>() {

    /**

    ViewHolder class for displaying a single Data object in the RecyclerView.

    @param itemView The View that represents a single item in the RecyclerView.
     */
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**

        Binds a Data object to the ViewHolder's itemView.
        @param data The Data object to bind to the ViewHolder's itemView.
         */
        fun bind(data: Data) {
            itemView.setOnClickListener {
// TODO: Implement click listener
            }
        }
    }

    /**

    Called when a new ViewHolder is created for a new item in the RecyclerView.
    @param parent The ViewGroup into which the new View will be added.
    @param viewType The type of the new View.
    @return A new DataViewHolder for the new item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.milongas_item,
            parent,
            false
        )
        return DataViewHolder(view)
    }

    /**

    Called when a ViewHolder needs to be updated with new data.
    @param holder The DataViewHolder to update.
    @param position The position of the item in the list.
     */
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = datas[position]
        holder.bind(data)
    }

    /**

    Returns the number of items in the list.
    @return The number of items in the list.
     */
    override fun getItemCount(): Int {
        return datas.size
    }
}