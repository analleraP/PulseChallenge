package com.allerap.android.pulsechallenge.feature.list

import android.content.Context
import com.allerap.android.pulsechallenge.feature.detail.detailIntent

class MainNavigator(private val context: Context)  {

    fun toDetailScreen(id: Int) {
        context.startActivity(context.detailIntent(id))
    }
}
