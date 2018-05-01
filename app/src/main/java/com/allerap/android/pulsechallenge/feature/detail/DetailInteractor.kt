package com.allerap.android.pulsechallenge.feature.detail

import com.allerap.android.pulsechallenge.CoroutineContextPool
import com.allerap.android.pulsechallenge.data.entities.Item
import com.allerap.android.pulsechallenge.data.entities.Error
import com.allerap.android.pulsechallenge.data.result.Result
import com.allerap.android.pulsechallenge.domain.Repository
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class DetailInteractor(private val contextPool: CoroutineContextPool,
                       private val repository: Repository) {

    fun getItem(id: Int, ui: (Result<Item, Error>) -> Unit
    ) = launch(contextPool.ui) {

        val result = async(contextPool.bg) {
            repository.getItem(id)
        }.await()

        ui(result)
    }
}
