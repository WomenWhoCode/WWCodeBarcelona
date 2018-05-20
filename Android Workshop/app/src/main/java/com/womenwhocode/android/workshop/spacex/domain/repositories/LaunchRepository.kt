package com.womenwhocode.android.workshop.spacex.domain.repositories

import com.womenwhocode.android.workshop.spacex.data.datasources.LaunchCloudDataSource
import com.womenwhocode.android.workshop.spacex.domain.model.Launch

/**
 * Created by Rocio Ortega on 20/05/2018.
 */
class LaunchRepository(private val cloudDataSource: LaunchCloudDataSource) {
    fun getLaunches(onSuccess: (List<Launch>) -> Unit, onError: (Throwable?) -> Unit) =
            cloudDataSource.getLaunches(onSuccess, onError)

}