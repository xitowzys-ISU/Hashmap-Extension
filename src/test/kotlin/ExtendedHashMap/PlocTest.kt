package ExtendedHashMap

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class PlocTest {

    val map = ExtendedHashMap()

    @BeforeAll
    fun beforeAll() {
        map["value1"] = 1
        map["value2"] = 2
        map["value3"] = 3
        map["1"] = 10
        map["2"] = 20
        map["3"] = 30
        map["(1, 5)"] = 100
        map["(5, 5)"] = 200
        map["(10, 5)"] = 300
        map["(1, 5, 3)"] = 400
        map["(5, 5, 4)"] = 500
        map["(10, 5, 5)"] = 600
    }

    @Test
    @DisplayName(">=1")
    fun plocTestOne() {
        val answer: HashMap<String, Int> = hashMapOf("1" to 10, "2" to 20, "3" to 30)
        assertTrue(map.ploc[">=1"] == answer)
    }

    @Test
    @DisplayName("<3")
    fun plocTestTwo() {
        val answer: HashMap<String, Int> = hashMapOf("1" to 10, "2" to 20)
        assertTrue(map.ploc["<3"] == answer)
    }

    @Test
    @DisplayName(">0, >0")
    fun plocTestThree() {
        val answer: HashMap<String, Int> = hashMapOf("(1, 5)" to 100, "(5, 5)" to 200, "(10, 5)" to 300)
        assertTrue(map.ploc[">0, >0"] == answer)
    }

    @Test
    @DisplayName(">=10, >0")
    fun plocTestFour() {
        val answer: HashMap<String, Int> = hashMapOf("(10, 5)" to 300)
        assertTrue(map.ploc[">=10, >0"] == answer)
    }

    @Test
    @DisplayName("<5, >=5, >=3")
    fun plocTestFive() {
        val answer: HashMap<String, Int> = hashMapOf("(1, 5, 3)" to 400)
        assertTrue(map.ploc["<5, >=      5, >=3   "] == answer)
    }

    @Test
    @DisplayName("=3")
    fun plocTestSix() {
        val answer: HashMap<String, Int> = hashMapOf("3" to 30)
        assertTrue(map.ploc["  =3   "] == answer)
    }

    @Test
    @DisplayName("<>1")
    fun plocTestSeven() {
        val answer: HashMap<String, Int> = hashMapOf("2" to 20, "3" to 30)
        assertTrue(map.ploc["<>1   "] == answer)
    }

    @Test
    @DisplayName("<=2")
    fun plocTestEight() {
        val answer: HashMap<String, Int> = hashMapOf("1" to 10, "2" to 20)
        assertTrue(map.ploc["<=2   "] == answer)
    }

    @Test
    @DisplayName("Exception invalid number")
    fun plocTestNine() {
        val exception: Exception = assertThrows(ExtendedHashMapException::class.java) {
            map.ploc[">> "]
        }

        assertEquals("Invalid number", exception.message)
    }

    @Test
    @DisplayName("Exception wrong operator")
    fun plocTestTen() {
        val exception: Exception = assertThrows(ExtendedHashMapException::class.java) {
            map.ploc[" 2 "]
        }

        assertEquals("Wrong operator", exception.message)
    }

    @Test
    @DisplayName("Exception wrong operator. Empty input")
    fun plocTestEleven() {
        val exception: Exception = assertThrows(ExtendedHashMapException::class.java) {
            map.ploc["  "]
        }

        assertEquals("Wrong operator", exception.message)
    }

}