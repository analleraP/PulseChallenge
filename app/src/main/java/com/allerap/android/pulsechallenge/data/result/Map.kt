package com.allerap.android.pulsechallenge.data.result

/**
 * Maps this [Result<V, E>][Result] to [Result<U, E>][Result] by either applying the [transform]
 * function to the [value][Ok.value] if this [Result] is [Ok], or returning this [Err].
 */
inline infix fun <V, E, U> Result<V, E>.map(transform: (V) -> U): Result<U, E> = when (this) {
  is Ok -> Ok(transform(value))
  is Err -> this
}

/**
 * Maps this [Result<V, E>][Result] to `U` by applying either the [success] function if this [Result]
 * is [Ok], or the [failure] function if this [Result] is an [Err]. Both of these functions must
 * return the same type (`U`).
 */
inline fun <V, E, U> Result<V, E>.mapBoth(
    success: (V) -> U,
    failure: (E) -> U
): U = when (this) {
  is Ok -> success(value)
  is Err -> failure(error)
}

