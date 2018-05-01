package com.allerap.android.pulsechallenge.data.result

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class MapTest {

    private sealed class MapError(val reason: String) {
        object HelloError : MapError("hello")
        class CustomError(reason: String) : MapError(reason)
    }

    @Test
    fun `map returns transformed value if Ok`() {
        assertEquals(
                expected = 30,
                actual = Ok(10).map { it + 20 }.get()
        )
    }

    @Test
    @Suppress("UNREACHABLE_CODE")
    fun `map returns error if Err`() {
        val result = Err(MapError.HelloError).map { "hello $it" }

        result as Err

        assertSame(
                expected = MapError.HelloError,
                actual = result.error
        )
    }

    @Test
    @Suppress("UNREACHABLE_CODE")
    fun `mapBoth returns transformed value if Ok`() {
        val value = Ok("there is").mapBoth(
                success = { "$it a light" },
                failure = { "$it that never" }
        )

        assertEquals(
                expected = "there is a light",
                actual = value
        )
    }

    @Test
    @Suppress("UNREACHABLE_CODE")
    fun `mapBoth returns transformed error if Err`() {
        val error = Err(MapError.CustomError("this")).mapBoth(
                success = { "$it charming" },
                failure = { "${it.reason} man" }
        )

        assertEquals(
                expected = "this man",
                actual = error
        )
    }
}
