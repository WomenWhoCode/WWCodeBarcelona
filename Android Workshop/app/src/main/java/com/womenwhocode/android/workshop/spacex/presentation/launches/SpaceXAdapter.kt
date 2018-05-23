package com.womenwhocode.android.workshop.spacex.presentation.launches

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.womenwhocode.android.workshop.spacex.R
import kotlinx.android.synthetic.main.launches_list_item.view.*

class SpaceXAdapter : RecyclerView.Adapter<SpaceXViewHolder>() {

    private val launches: ArrayList<ViewLaunch> = ArrayList()

    fun setLaunches(launches: List<ViewLaunch>?) {
        this.launches.clear()
        launches?.let {
            this.launches.addAll(it)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceXViewHolder {
        return SpaceXViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.launches_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: SpaceXViewHolder, position: Int) {
        GlideApp.with(holder.nameTv.context).load(launches[position].smallImage).into(holder.smallIv)
        holder.nameTv.text = launches[position].missionName
        holder.yearTv.text = launches[position].launchYear
        val color = if (launches[position].launchSuccess) Color.GREEN else Color.RED
        holder.yearTv.setTextColor(color)
        holder.locationTv.text = launches[position].siteName
    }

    override fun getItemCount(): Int = launches.size

    fun getItem(position: Int): ViewLaunch = launches[position]
}

class SpaceXViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val smallIv: ImageView = view.smallIv
    val nameTv: TextView = view.nameTv
    val yearTv: TextView = view.yearTv
    val locationTv: TextView = view.locationTv
}
