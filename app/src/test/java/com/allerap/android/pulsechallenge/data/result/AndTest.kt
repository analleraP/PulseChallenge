package com.allerap.android.pulsechallenge.data.result

import kotlin.test.Test
import kotlin.test.assertEquals

class AndTest {

    private object AndError

    @Test
    fun `and returns value if Ok`() {
        assertEquals(
                expected = 500,
                actual = Ok(230).and { Ok(500) }.get()
        )
    }

    @Test
    fun `and returns value if Err`() {
        assertEquals(
                expected = "hello world",
                actual = Ok(300).and { Err("hello world") }.getError()
        )
    }
}


