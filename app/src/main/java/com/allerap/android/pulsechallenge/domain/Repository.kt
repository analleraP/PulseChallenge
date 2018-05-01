package com.allerap.android.pulsechallenge.domain

import com.allerap.android.pulsechallenge.data.entities.Item
import com.allerap.android.pulsechallenge.data.remote.ApiRemoteSource
import com.allerap.android.pulsechallenge.data.result.Result

class Repository(private val remoteSource: ApiRemoteSource) {

    fun getItems(): Result<List<Item>, Error> =
            remoteSource.getItems()

    fun getItem(id: Int): Result<Item, Error> =
            remoteSource.getItem(id)
}
