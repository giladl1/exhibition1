package com.levins.Matrix_Gilad_Levinson

import kotlinx.coroutines.*
import model.Controller
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @ExperimentalCoroutinesApi
    @Test
    fun addition_isCorrect() = runBlocking{
        val controller = Controller()
//        CoroutineScope(Dispatchers.IO).launch {
            val locations = controller.getLocationsFromJsoup()
//        }
        assertNotEquals(locations, null)
//        assertEquals(4, 2 + 2)

    }
}