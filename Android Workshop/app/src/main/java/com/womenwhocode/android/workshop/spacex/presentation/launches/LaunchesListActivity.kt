package com.womenwhocode.android.workshop.spacex.presentation.launches

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.womenwhocode.android.workshop.spacex.R
import com.womenwhocode.android.workshop.spacex.presentation.detail.LaunchDetailActivity
import kotlinx.android.synthetic.main.activity_launches_list.*
import org.koin.android.ext.android.inject

/**
 * Created by Rocio Ortega on 19/05/2018.
 * Class used to see a list of Launches
 */
class LaunchesListActivity : AppCompatActivity(), LaunchesListView {
    //Presenter injected in the Activity
    private val presenter: LaunchesListPresenter by inject()
    //Adapter used for displaying items in the RecyclerView
    private var adapter: SpaceXAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //"Add a view to the Activity. setContentView(.....)"
        setContentView(R.layout.activity_launches_list)
        //Init presenter
        presenter.view=this

        //"Configurate the list"
        this.adapter = SpaceXAdapter()
        launchesRv.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        launchesRv.adapter = adapter
        launchesRv.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                var viewLaunch: ViewLaunch? = adapter?.getItem(position)
                startActivity(LaunchDetailActivity.newIntent(view.context, viewLaunch))
            }
        })
        launchesSrl.setOnRefreshListener {
            presenter.loadLaunches()
        }
        //"Tell the presenter to load the launches"
        presenter.loadLaunches()
    }

    override fun displayLaunches(launches: List<ViewLaunch>?) {
        Log.i("LaunchesListPresenter", launches?.toString())
        //"Add the items to the adapter"
        adapter?.setLaunches(launches)
    }

    override fun showLoading() {
        launchesSrl.isRefreshing = true
        // Network calls take time, we do not want the user to wonder if our app
       // is broken so we need to show some UI to inform the user to wait

    }

    override fun hideLoading() {
        launchesSrl.isRefreshing = false
    }

    override fun showErrorGettingLaunches() {
       ///"Show a snackbar containing an error message"
        Snackbar.make(rootLayout, getString(R.string.list_get_launches_error), Snackbar.LENGTH_LONG)
                .show()
    }
}
