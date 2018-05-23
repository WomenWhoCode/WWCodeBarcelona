package com.womenwhocode.android.workshop.spacex.presentation.launches

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
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
        launchesRv.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        launchesRv.adapter = adapter
        launchesSrl.setOnRefreshListener {
            presenter.loadLaunches()
        }
        presenter.loadLaunches()
    }

    override fun displayLaunches(launches: List<ViewLaunch>?) {
        Log.i("LaunchesListPresenter", launches?.toString())
        adapter?.setLaunches(launches)
    }

    override fun showLoading() {
        launchesSrl.isRefreshing = true
    }

    override fun hideLoading() {
        launchesSrl.isRefreshing = false
    }

    override fun showErrorGettingLaunches() {
        Snackbar.make(rootLayout, getString(R.string.list_get_launches_error), Snackbar.LENGTH_LONG)
                .show()
    }
}
