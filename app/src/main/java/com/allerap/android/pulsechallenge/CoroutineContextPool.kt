package com.allerap.android.pulsechallenge

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

open class CoroutineContextPool {
  open val ui: CoroutineContext by lazy { UI }
  open val bg: CoroutineContext by lazy { CommonPool }
}
