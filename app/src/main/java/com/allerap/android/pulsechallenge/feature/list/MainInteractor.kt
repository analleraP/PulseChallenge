package com.allerap.android.pulsechallenge.feature.list

import com.allerap.android.pulsechallenge.CoroutineContextPool
import com.allerap.android.pulsechallenge.data.entities.Item
import com.allerap.android.pulsechallenge.data.entities.Error
import com.allerap.android.pulsechallenge.data.result.Result
import com.allerap.android.pulsechallenge.domain.Repository
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class MainInteractor(private val contextPool: CoroutineContextPool,
                     private val repository: Repository) {

    fun getItems(ui: (Result<List<Item>, Error>) -> Unit
    ) = launch(contextPool.ui) {

        val result = async(contextPool.bg) {
            repository.getItems()
        }.await()

        ui(result)
    }
}
