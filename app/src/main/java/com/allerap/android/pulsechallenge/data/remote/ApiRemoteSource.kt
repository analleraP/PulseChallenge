package com.allerap.android.pulsechallenge.data.remote

import com.allerap.android.pulsechallenge.data.entities.Item
import com.allerap.android.pulsechallenge.data.entities.Error
import com.allerap.android.pulsechallenge.data.result.Result
import com.allerap.android.pulsechallenge.data.result.map

class ApiRemoteSource(private val service: ApiService) : BaseRemoteSource() {

    fun getItems(): Result<List<Item>, Error> {
        return call(service.getItems()).map {
            it.items
        }
    }

    fun getItem(id: Int): Result<Item, Error> {
        return call(service.getItem(id)).map {
            it.item
        }
    }
}
