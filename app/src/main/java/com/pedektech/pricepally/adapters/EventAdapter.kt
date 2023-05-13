package com.pedektech.pricepally.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedektech.pricepally.R
import com.pedektech.pricepally.model.Data
/**

Adapter for a RecyclerView to display a list of Data objects.

@param datas The list of Data objects to be displayed in the RecyclerView
 */
class EventAdapter(private val datas: List<Data>) :
    RecyclerView.Adapter<EventAdapter.DataViewHolder>() {

    /**

    ViewHolder for a single item in the RecyclerView.

    @param itemView The View for a single item in the RecyclerView
     */
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**

        Binds a Data object to the ViewHolder.
        @param data The Data object to bind to the ViewHolder
         */
        fun bind(data: Data) {
            itemView.setOnClickListener {
        // Handle click event here
            }
        }
    }
    /**

    Creates a new ViewHolder for a single item in the RecyclerView.
    @param parent The ViewGroup that the new ViewHolder will be added to
    @param viewType The type of the new ViewHolder
    @return The new ViewHolder for a single item in the RecyclerView
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return DataViewHolder(view)
    }
    /**

    Binds a Data object to a ViewHolder.
    @param holder The ViewHolder to bind the Data object to
    @param position The position of the Data object in the list
     */
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = datas[position]
        holder.bind(data)
    }
    /**

    Returns the number of items in the list of Data objects.
    @return The number of items in the list of Data objects
     */
    override fun getItemCount(): Int {
        return datas.size
    }
}