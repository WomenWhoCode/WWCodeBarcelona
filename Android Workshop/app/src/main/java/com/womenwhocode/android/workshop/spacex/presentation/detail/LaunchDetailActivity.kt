package com.womenwhocode.android.workshop.spacex.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.squareup.picasso.Picasso
import com.womenwhocode.android.workshop.spacex.R
import com.womenwhocode.android.workshop.spacex.domain.model.Launch
import kotlinx.android.synthetic.main.activity_launch_detail.*
import org.koin.android.ext.android.get

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

        val missionName = intent.extras.getString(LAUNCH_MISSION_NAME)
        val launchYear = intent.extras.getString(LAUNCH_YEAR)
        val launchSuccess = intent.extras.getBoolean(LAUNCH_SUCCESS)
        val details = intent.extras.getString(LAUNCH_DETAILS, "")
        val rocketName = intent.extras.getString(LAUNCH_ROCKET)
        val siteName = intent.extras.getString(LAUNCH_SITE)
        val image = intent.extras.getString(LAUNCH_IMAGE)

        presenter.loadLaunchDetail(missionName, launchYear, launchSuccess, details, rocketName, siteName, image)
    }


    override fun displayLaunchDetail(missionName: String, launchYear: String, launchSuccess: Boolean, details: String, rocketName: String, siteName: String, image: String) {
        title = missionName
        missionNameLaunch.text = missionName
        yearOfLaunch.text = launchYear
        rocketNameLaunch.text = rocketName
        siteInfoLaunch.text = siteName
        successOfLaunch.text= launchSuccess.toString()
        if (details.isEmpty()) {
            rocketDetailInfoContainer.visibility = View.GONE
        }else{
            rocketDetail.text=details
        }
        Picasso.get().load(image).into(launchImg)
    }


    companion object {

        const val LAUNCH_MISSION_NAME: String = "launch.mision.name"
        const val LAUNCH_YEAR: String = "launch.year"
        const val LAUNCH_SUCCESS: String = "launch.success"
        const val LAUNCH_DETAILS: String = "launch.detail"
        const val LAUNCH_ROCKET: String = "launch.rocket"
        const val LAUNCH_SITE: String = "launch.site"
        const val LAUNCH_IMAGE: String = "launch.image"

        fun newIntent(context: Context, launch: Launch): Intent {
            val intent = Intent(context, LaunchDetailActivity::class.java)

            intent.putExtra(LAUNCH_MISSION_NAME, launch.missionName)
            intent.putExtra(LAUNCH_YEAR, launch.launchYear)
            intent.putExtra(LAUNCH_SUCCESS, launch.launchSuccess)
            intent.putExtra(LAUNCH_DETAILS, launch.details)
            intent.putExtra(LAUNCH_ROCKET, launch.rocket.name)
            intent.putExtra(LAUNCH_SITE, launch.site.name)
            intent.putExtra(LAUNCH_IMAGE, launch.image)
            return intent
        }
    }

}