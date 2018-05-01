package com.allerap.android.pulsechallenge.data.result

/**
 * Returns [result] if this [Result] is [Ok], otherwise this [Err].
 */
inline infix fun <V, E> Result<V, E>.and(result: () -> Result<V, E>): Result<V, E> = when (this) {
    is Ok -> result()
    is Err -> this
}
