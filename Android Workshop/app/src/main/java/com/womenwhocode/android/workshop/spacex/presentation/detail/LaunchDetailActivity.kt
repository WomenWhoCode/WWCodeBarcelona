package com.womenwhocode.android.workshop.spacex.presentation.detail

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.womenwhocode.android.workshop.spacex.R
import com.womenwhocode.android.workshop.spacex.presentation.launches.GlideApp
import com.womenwhocode.android.workshop.spacex.presentation.launches.ViewLaunch
import kotlinx.android.synthetic.main.activity_launch_detail.*
import org.koin.android.ext.android.get

/**
 *  :3
 */

private const val LAUNCH_MISSION_NAME: String = "launch.mision.name"
private const val LAUNCH_YEAR: String = "launch.year"
private const val LAUNCH_SUCCESS: String = "launch.success"
private const val LAUNCH_DETAILS: String = "launch.detail"
private const val LAUNCH_ROCKET: String = "launch.rocket"
private const val LAUNCH_SITE: String = "launch.site"
private const val LAUNCH_IMAGE: String = "launch.image"

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
        val color = if (launchSuccess) Color.GREEN else Color.RED
        successOfLaunch.text = if (launchSuccess) "Success :D" else "Not success :("
        successOfLaunch.setTextColor(color)
        if (details.isEmpty()) {
            rocketDetailInfoContainer.visibility = View.GONE
        } else {
            rocketDetail.text = details
        }
        GlideApp.with(this)
                .load(image)
                .into(launchImg)
                .waitForLayout()

    }


    companion object {

        fun newIntent(context: Context, launch: ViewLaunch?): Intent {
            val intent = Intent(context, LaunchDetailActivity::class.java)
            launch?.let {
                intent.putExtra(LAUNCH_MISSION_NAME, it.missionName)
                intent.putExtra(LAUNCH_YEAR, it.launchYear)
                intent.putExtra(LAUNCH_SUCCESS, it.launchSuccess)
                intent.putExtra(LAUNCH_DETAILS, it.details)
                intent.putExtra(LAUNCH_ROCKET, it.rocketName)
                intent.putExtra(LAUNCH_SITE, it.siteName)
                intent.putExtra(LAUNCH_IMAGE, it.image)
            }

            return intent
        }
    }

}