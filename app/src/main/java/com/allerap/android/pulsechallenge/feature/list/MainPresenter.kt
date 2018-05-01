package com.allerap.android.pulsechallenge.feature.list

import android.content.Context
import com.allerap.android.pulsechallenge.CoroutineContextPool
import com.allerap.android.pulsechallenge.data.result.onFailure
import com.allerap.android.pulsechallenge.data.result.onSuccess
import com.allerap.android.pulsechallenge.domain.BusinessModule

class MainPresenter(private val view: MainView, context: Context) {

    private var interactor = MainInteractor(CoroutineContextPool(), BusinessModule.repository)
    private var navigator = MainNavigator(context)

    init {
        view.showLoading()
        getItems()
    }

    fun onItemClick(id: Int) {
        navigator.toDetailScreen(id)
    }

    private fun getItems() = interactor.getItems {

        view.hideLoading()

        it.onSuccess {
            view.showItems(it)
        }

        it.onFailure {
            view.handleError(it.message)
        }
    }
}
