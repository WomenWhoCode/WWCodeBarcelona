package com.womenwhocode.android.workshop.spacex.domain.usecases

import com.womenwhocode.android.workshop.spacex.domain.model.Launch
import com.womenwhocode.android.workshop.spacex.domain.repositories.LaunchRepository

/**
 * Created by Rocio Ortega on 20/05/2018.
 */
class GetLaunchesUseCase(private val repository: LaunchRepository) {
    fun execute(onSuccess: (List<Launch>) -> Unit, onError: (Throwable?) -> Unit) {
        repository.getLaunches(onSuccess, onError)
    }
}