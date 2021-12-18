package utils

fun String.intOrString(): Boolean {
    val v = this.toIntOrNull()
    return when(v) {
        null -> false
        else -> true
    }
}