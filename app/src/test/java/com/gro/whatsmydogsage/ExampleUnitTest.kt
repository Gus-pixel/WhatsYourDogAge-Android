package com.gro.whatsmydogsage

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class WhatsMyDogAgeScreenTest {
    @Test
    fun testSmallSize() {
        assertEquals("42", smallSize(6))
    }

    @Test
    fun testBigSize() {
        assertEquals("50", bigSize(6))
    }
}