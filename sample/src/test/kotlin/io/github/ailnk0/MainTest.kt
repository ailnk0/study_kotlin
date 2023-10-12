package io.github.ailnk0

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MainTest {
    @Test
    fun testInfixFun() {
        run {
            infix fun Int.times(str: String) = str.repeat(this)
            val expected = "Bye-Bye-"
            val actual = 2 times "Bye-"
            Assertions.assertEquals(expected, actual)
        }

        // Eg. Infix is already defined in Pair
        run {
            val expected = Pair("name", "Lee")
            val actual = "name" to "Lee"
            Assertions.assertEquals(expected, actual)
        }

        run {
            class Person(val name: String) {
                val likes = mutableListOf<Person>()
                infix fun like(that: Person) = this.likes.add(that)
            }

            val kim = Person("Kim")
            val lee = Person("Lee")
            val ok = kim like lee

            Assertions.assertTrue(ok)
            Assertions.assertTrue(kim.likes.contains(lee))
        }
    }

    @Test
    fun testOpFun() {
        run {
            operator fun Int.times(str: String) = str.repeat(this)
            val expected = "Bye-Bye-"
            val actual = 2 * "Bye-"
            Assertions.assertEquals(expected, actual)
        }

        run {
            val text = "Bye-Bye-"
            operator fun String.get(range: IntRange) = substring(range)
            val expected = "e-B"
            val actual = text[2..4]
            Assertions.assertEquals(expected, actual)
        }
    }

    @Test
    fun testVararg() {
        fun getLog(vararg log: String, prefix: String) = log.joinToString(prefix = prefix)
        val expected = "[LOG] Alpha, Beta, Gamma"
        val actual = getLog("Alpha", "Beta", "Gamma", prefix = "[LOG] ")
        Assertions.assertEquals(expected, actual)
    }
}
