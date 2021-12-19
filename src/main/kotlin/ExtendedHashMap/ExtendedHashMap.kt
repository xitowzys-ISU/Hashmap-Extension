package ExtendedHashMap

import ExtendedHashMap.Lexer.Token.Enums.ComparisonOperators
import ExtendedHashMap.Lexer.Lexer
import ExtendedHashMap.Lexer.Token.Interfaces.ITokenType
import utils.intOrString

class ExtendedHashMap : HashMap<String, Int>() {

    val iloc = ILOC()

    inner class ILOC() {
        operator fun get(index: Int): Int? {
            return this@ExtendedHashMap.iloc(index)
        }
    }

    private fun iloc(i: Int): Int? {
        val sortedSet = this.keys.toSortedSet()
        return if (i < 0 || i >= sortedSet.size) null else this[sortedSet.elementAt(i)]
    }

    val ploc = PLOC()

    inner class PLOC() {
        operator fun get(cond: String): HashMap<String, Int> {
            return this@ExtendedHashMap.ploc(cond)
        }
    }

    private fun ploc(condition: String): HashMap<String, Int> {
        val conditions: List<String> = condition.split(",").map { it.trim() }
        val result = ExtendedHashMap()

        for (key in this.keys) {
            val subKeys = key.trim('(', ')').split(",").map { it.trim() }

            if (subKeys.size == conditions.size) {
                var flag = true

                for (i in subKeys.indices) if (parse(subKeys[i], conditions[i]).not()) flag = flag.not()

                if (flag) result[key] = this[key] ?: 0
            }
        }

        return result
    }

    private fun parse(key: String, condition: String): Boolean {
        val lexer = Lexer(condition)

        val op: ITokenType = lexer.getNextToken().type

        val right: Int? = lexer.getNextToken().value

        if (op::class.java.name != ComparisonOperators::class.java.name)
            throw ExtendedHashMapException("Wrong operator")


        if (right == null || op::class.java.name != ComparisonOperators::class.java.name)
            throw ExtendedHashMapException("Invalid number")

        val left = if (key.intOrString()) key.toInt() else return false

        return when (op) {
            ComparisonOperators.OVER -> left > right
            ComparisonOperators.OVER_EQUAL -> left >= right
            ComparisonOperators.LESS -> left < right
            ComparisonOperators.LESS_EQUAL -> left <= right
            ComparisonOperators.EQUAL -> left == right
            else -> left != right
        }
    }
}
