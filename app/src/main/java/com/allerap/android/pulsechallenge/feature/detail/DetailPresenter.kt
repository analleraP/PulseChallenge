package com.allerap.android.pulsechallenge.feature.detail

import com.allerap.android.pulsechallenge.CoroutineContextPool
import com.allerap.android.pulsechallenge.data.result.onFailure
import com.allerap.android.pulsechallenge.data.result.onSuccess
import com.allerap.android.pulsechallenge.domain.BusinessModule

class DetailPresenter(private val view: DetailView, id: Int) {

    private var interactor = DetailInteractor(CoroutineContextPool(), BusinessModule.repository)

    init {
        view.showLoading()
        getItem(id)
    }

    private fun getItem(id: Int) = interactor.getItem(id) {

        view.hideLoading()

        it.onSuccess {
            view.showItem(it)
        }

        it.onFailure {
            view.handleError(it.message)
        }
    }
}
