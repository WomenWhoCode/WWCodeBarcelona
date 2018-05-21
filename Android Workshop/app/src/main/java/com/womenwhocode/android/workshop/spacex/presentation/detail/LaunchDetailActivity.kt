package com.womenwhocode.android.workshop.spacex.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.womenwhocode.android.workshop.spacex.R
import com.womenwhocode.android.workshop.spacex.domain.model.Launch
import kotlinx.android.synthetic.main.activity_launch_detail.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

/**
 *  :3
 */

class LaunchDetailActivity : AppCompatActivity(), LaunchDetailView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_detail)
        val presenter = get<LaunchDetailPresenter>()

        title = "Detail"
        presenter.view = this
        val launch = intent.extras.getParcelable<Launch>(LAUCH_DATA)
        presenter.loadLaunchDetail(launch)
    }

    override fun displayLaunchDetail(launch: Launch) {
        title = launch.missionName
        missionNameLaunch.text = launch.missionName
        launchYear.text = launch.launchYear
        rocketNameLaunch.text = launch.rocket.name
        rocketTypeLaunch.text = launch.rocket.type
        siteInfoLaunch.text = launch.site.nameLong
        Picasso.get().load(launch.image).into(launchImg)
    }


    companion object {

        const val LAUCH_DATA: String = "launch.data"

        fun newIntent(context: Context, launch: Launch): Intent {
            val intent = Intent(context, LaunchDetailActivity::class.java)
            intent.putExtra(LAUCH_DATA,launch)
            return intent
        }
    }

}