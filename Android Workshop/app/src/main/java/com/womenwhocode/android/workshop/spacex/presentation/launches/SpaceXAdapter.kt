package com.womenwhocode.android.workshop.spacex.presentation.launches

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

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
        TODO("not implemented")
    }

    override fun onBindViewHolder(holder: SpaceXViewHolder, position: Int) {
        TODO("not implemented")
    }

    override fun getItemCount(): Int {
        TODO("not implemented")
    }
}

class SpaceXViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}
