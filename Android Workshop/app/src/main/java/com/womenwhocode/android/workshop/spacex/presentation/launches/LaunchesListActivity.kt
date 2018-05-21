package com.womenwhocode.android.workshop.spacex.presentation.launches

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.womenwhocode.android.workshop.spacex.R
import com.womenwhocode.android.workshop.spacex.domain.model.Launch
import kotlinx.android.synthetic.main.activity_launches_list.*
import org.koin.android.ext.android.inject

/**
 * Created by Rocio Ortega on 19/05/2018.
 */
class LaunchesListActivity: AppCompatActivity(), LaunchesListView {

    val presenter : LaunchesListPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launches_list)
        presenter.view = this
        launches_rv.layoutManager = GridLayoutManager(this, 2)
        launches_rv.adapter = SpaceXAdapter();
    }

    override fun displayLaunches(launches: List<Launch>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
