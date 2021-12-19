package ExtendedHashMap

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class IlocTest {

    val map = ExtendedHashMap()

    @BeforeAll
    fun beforeAll() {
        map["value1"] = 1
        map["value2"] = 2
        map["value3"] = 3
        map["1"] = 10
        map["2"] = 20
        map["3"] = 30
        map["1, 5"] = 100
        map["5, 5"] = 200
        map["10, 5"] = 300
    }

    @Test
    @DisplayName("Iloc tests")
    fun ilocTestOne() {
        assertEquals(10, map.iloc[0])
        assertEquals(300, map.iloc[2])
        assertEquals(200, map.iloc[5])
        assertEquals(3, map.iloc[8])
        assertNull(map.iloc[1000])
        assertNull(map.iloc[-1])
    }

}