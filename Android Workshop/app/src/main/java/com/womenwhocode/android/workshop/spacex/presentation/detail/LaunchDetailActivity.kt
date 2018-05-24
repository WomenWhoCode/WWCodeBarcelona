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
 * Activity used to see the details of a rocket launch
 */

///TODO Add here the variables for handle intent extras

class LaunchDetailActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_detail)
        ///TODO add Presenter configuration
    }

   //Use this factory method to create a new instance of
   // this fragment using the provided parameters.
    companion object {

        fun newIntent(context: Context, launch: ViewLaunch?): Intent {
            val intent = Intent(context, LaunchDetailActivity::class.java)
            launch?.let {
            }
            return intent
        }
    }

}