package com.allerap.android.pulsechallenge.data.result

/**
 * Returns the [value][Ok.value] if this [Result] is [Ok], otherwise `null`.
 */
fun <V, E> Result<V, E>.get(): V? = when (this) {
    is Ok -> value
    is Err -> null
}

/**
 * Returns the [error][Err.error] if this [Result] is [Err], otherwise `null`.
 */
fun <V, E> Result<V, E>.getError(): E? = when (this) {
    is Ok -> null
    is Err -> error
}