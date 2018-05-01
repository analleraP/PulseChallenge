package com.allerap.android.pulsechallenge.feature.list

import com.allerap.android.pulsechallenge.data.entities.Item

interface MainView {

    fun showLoading()

    fun hideLoading()

    fun handleError(message: String)

    fun showItems(items: List<Item>)
}
