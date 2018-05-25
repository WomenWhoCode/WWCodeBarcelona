package com.womenwhocode.android.workshop.spacex.presentation.launches


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.womenwhocode.android.workshop.spacex.R
import kotlinx.android.synthetic.main.launches_list_item.view.*

//Class that tells to the RecyclerView how the items have to be displayed
//Also responsible to create each item and recycle them while scrolling
class SpaceXAdapter : RecyclerView.Adapter<SpaceXViewHolder>() {

    private val launches: ArrayList<ViewLaunch> = ArrayList()

    fun setLaunches(launches: List<ViewLaunch>?) {
        this.launches.clear()
        //Added all the data that has to be displayed
        launches?.let {
            this.launches.addAll(it)
        }
        notifyDataSetChanged()
    }

    //This fun creates a holder with the info of each item of the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceXViewHolder {
        return SpaceXViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.launches_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: SpaceXViewHolder, position: Int) {
        //Fill every item of the view with the fields of ViewLaunch to be displayed
        //Example
        //GlideApp.with(holder.nameTv.context).load(launches[position].smallImage).into(holder.smallIv)
    }

    override fun getItemCount(): Int = launches.size

    fun getItem(position: Int): ViewLaunch = launches[position]
}

class SpaceXViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val smallIv: ImageView = view.smallIv
    // bind vars with the view elements
}
