package com.everis.listadecontatos

import android.content.Context
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import androidx.test.core.app.ApplicationProvider


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class ContatoHelperTest {
    private val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
