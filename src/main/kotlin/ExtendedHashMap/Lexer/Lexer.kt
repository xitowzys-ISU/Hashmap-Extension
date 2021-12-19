package ExtendedHashMap.Lexer

import ExtendedHashMap.Lexer.Token.Enums.ComparisonOperators
import ExtendedHashMap.Lexer.Token.Enums.General
import ExtendedHashMap.Lexer.Token.Token

class Lexer(private val text: String) {
    private var pos: Int = 0
    private var currentChar: Char? = if (text.isEmpty()) null else text[pos]

    private fun advance() {
        pos++
        currentChar = if (pos > text.length - 1) null else text[pos]
    }

    private fun skipWhitespace() {
        while (currentChar != null && currentChar!!.isWhitespace()) advance()
    }

    private fun peek(): Char? {
        val peekPos = pos + 1
        return if (peekPos > text.length - 1) null else text[peekPos]
    }

    private fun integer(): Int {
        var result = ""
        while (currentChar != null && currentChar!!.isDigit()) {
            result += currentChar
            advance()
        }

        return result.toInt()
    }

    fun getNextToken(): Token {
        while (currentChar != null) {

            if (currentChar == '>' && peek() == '=') {
                advance()
                advance()
                return Token(ComparisonOperators.OVER_EQUAL, null)
            }

            if (currentChar == '<' && peek() == '>') {
                advance()
                advance()
                return Token(ComparisonOperators.NOT_EQUAL, null)
            }

            if (currentChar == '<' && peek() == '=') {
                advance()
                advance()
                return Token(ComparisonOperators.LESS_EQUAL, null)
            }

            if (currentChar == '>') {
                advance()
                return Token(ComparisonOperators.OVER, null)
            }

            if (currentChar == '<') {
                advance()
                return Token(ComparisonOperators.LESS, null)
            }

            if (currentChar == '=') {
                advance()
                return Token(ComparisonOperators.EQUAL, null)
            }

            if (currentChar!!.isDigit()) {
                return Token(General.INDEX, integer())
            }

            if (currentChar!!.isWhitespace()) {
                skipWhitespace()
                continue
            }
        }

        return Token(General.EOS, null)
    }
}