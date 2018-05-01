package com.allerap.android.pulsechallenge.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import com.allerap.android.pulsechallenge.R

fun ViewGroup.showLoading(layoutInflater: LayoutInflater) {

  val loadingView = layoutInflater
      .inflate(R.layout.view_loading, this)
  bringChildToFront(loadingView)
}

fun ViewGroup.hideLoading() {
  for (index in 0 until childCount) {
    if (getChildAt(index).tag == "layoutOverlay") {
      removeView(getChildAt(index))
    }
  }
}
