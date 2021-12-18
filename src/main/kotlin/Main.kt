import ExtendedHashMap.ExtendedHashMap

fun main() {
    val map = ExtendedHashMap()

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

    println(map.iloc[0])
    println(map.iloc[2])
    println(map.iloc[5])
    println(map.iloc[8])

    println(map.ploc[">= 1"])
    println(map.ploc["< 3"])
    println(map.ploc[">0, >0"])
    println(map.ploc[">= 10, >0"])
    println(map.ploc["<5, >=5, >=3"])
}