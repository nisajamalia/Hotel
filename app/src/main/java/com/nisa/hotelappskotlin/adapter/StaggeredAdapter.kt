package com.nisa.hotelappskotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nisa.hotelappskotlin.R
import com.nisa.hotelappskotlin.model.Model
import kotlinx.android.synthetic.main.activity_detail_popular_hotel.view.*
import kotlinx.android.synthetic.main.item_staggered_row.view.*


class StaggeredAdapter(private val listStaggered:ArrayList<Model>) : RecyclerView.Adapter<StaggeredAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            //knp false? karna attach to root value
            .inflate(R.layout.item_staggered_row, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int = listStaggered.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStaggered[position])
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: Model) {
            with(itemView) {
                Glide.with(itemView)
                    .load(model.image)
                    .apply(RequestOptions().override(400))
                    .into(iv_staggered_food)

                tv_staggered_name_food.text = model.title
                tv_staggered_desc2_food.text = model.desc
                tv_staggered_address2_food.text = model.address
                txtprice.text = model.price


            }
        }


    }
}