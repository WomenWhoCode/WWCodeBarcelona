package com.womenwhocode.android.workshop.spacex.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.womenwhocode.android.workshop.spacex.R
import com.womenwhocode.android.workshop.spacex.presentation.launches.ViewLaunch
import org.koin.android.ext.android.inject

/**
 * Activity used to see the details of a rocket launch
 */

private const val LAUNCH_MISSION_NAME: String = "launch.mision.name"
private const val LAUNCH_YEAR: String = "launch.year"
private const val LAUNCH_SUCCESS: String = "launch.success"
private const val LAUNCH_DETAILS: String = "launch.detail"
private const val LAUNCH_ROCKET: String = "launch.rocket"
private const val LAUNCH_SITE: String = "launch.site"
private const val LAUNCH_IMAGE: String = "launch.image"

class LaunchDetailActivity : AppCompatActivity(), LaunchDetailView {

    private val presenter: LaunchDetailPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_detail)

        title = "Detail"
        presenter.view = this

        val missionName = intent.extras.getString(LAUNCH_MISSION_NAME)
        val image = intent.extras.getString(LAUNCH_IMAGE)
        //Call the presenter with the data we want to show

    }

   //Use this factory method for create a new instance of
   // this activity using the provided parameters.
    companion object {

        fun newIntent(context: Context, launch: ViewLaunch?): Intent {
            val intent = Intent(context, LaunchDetailActivity::class.java)
            //Finish to add all the data that we want in the view
            launch?.let {
                intent.putExtra(LAUNCH_MISSION_NAME, it.missionName)
                intent.putExtra(LAUNCH_IMAGE, it.image)
            }
            return intent
        }
    }

}