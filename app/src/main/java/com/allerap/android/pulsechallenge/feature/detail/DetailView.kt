package com.allerap.android.pulsechallenge.feature.detail

import com.allerap.android.pulsechallenge.data.entities.Item

interface DetailView {

    fun showLoading()

    fun hideLoading()

    fun handleError(message: String)

    fun showItem(item: Item)
}
