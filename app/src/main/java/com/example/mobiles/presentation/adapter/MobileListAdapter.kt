package com.example.mobiles.presentation.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiles.R
import com.example.mobiles.presentation.model.MobileModel
import com.example.mobiles.presentation.RecyclerView.RecyclerViewInterface

class mobileListAdapter(
    private val context: Context,
    private val mobileList: List<MobileModel>,
    private val recyclerViewInterface: RecyclerViewInterface
) : RecyclerView.Adapter<mobileListAdapter.ViewHolder>() {


    class ViewHolder(ItemView: View, private val recyclerViewInterface: RecyclerViewInterface) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.mobile_image)
        val nameTextView: TextView = itemView.findViewById(R.id.mobile_name)
        val priceTextView: TextView = itemView.findViewById(R.id.mobile_price)
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mobile_item,parent,false)
        return ViewHolder(view,recyclerViewInterface)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = mobileList[position]
        holder.nameTextView.text = model.name
        holder.priceTextView.text = model.price.toString()
        holder.imageView.setImageResource(model.image)
        holder.itemView.setOnClickListener(View.OnClickListener {
            recyclerViewInterface.onItemClicked(position)
        })

    }

    override fun getItemCount(): Int {
        return mobileList.size
    }


}