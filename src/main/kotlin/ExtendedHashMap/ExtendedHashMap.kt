package ExtendedHashMap

class ExtendedHashMap : HashMap<String, Int>() {

    val iloc = ILOC()
    inner class ILOC(){
        operator fun get(index: Int): Int? {
            return this@ExtendedHashMap.iloc(index)
        }
    }

    private fun iloc(i: Int): Int? {
        val sortedSet = this.keys.toSortedSet()
        return if (i < 0 || i >= sortedSet.size) null else this[sortedSet.elementAt(i)]
    }

    val ploc = PLOC()
    inner class PLOC(){
        operator fun get(cond: String): HashMap<String, Int> {
            return this@ExtendedHashMap.ploc(cond)
        }
    }

    private fun ploc(cond: String): HashMap<String, Int> {
        return ExtendedHashMap()
    }
}
