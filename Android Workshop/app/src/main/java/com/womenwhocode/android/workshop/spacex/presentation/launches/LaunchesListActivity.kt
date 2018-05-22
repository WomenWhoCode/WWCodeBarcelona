package com.womenwhocode.android.workshop.spacex.presentation.launches

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.womenwhocode.android.workshop.spacex.R
import kotlinx.android.synthetic.main.activity_launches_list.*
import org.koin.android.ext.android.inject

/**
 * Created by Rocio Ortega on 19/05/2018.
 */
class LaunchesListActivity: AppCompatActivity(), LaunchesListView {

    private val presenter: LaunchesListPresenter by inject()

    private var adapter: SpaceXAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launches_list)
        presenter.view = this
        this.adapter = SpaceXAdapter()
        launches_rv.layoutManager = GridLayoutManager(this, 2) //TODO: extract and configure according to device?
        launches_rv.adapter = adapter
        presenter.loadLaunches()
    }

    override fun displayLaunches(launches: List<ViewLaunch>?) {
        Log.i("LaunchesListPresenter", launches?.toString())
        adapter?.setLaunches(launches)
    }

    override fun showLoading() {
        //TODO("not implemented")
    }
}
