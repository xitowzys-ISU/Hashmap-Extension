package ExtendedHashMap.Lexer.Token.Enums

import ExtendedHashMap.Lexer.Token.Interfaces.ITokenType

enum class ComparisonOperators(val token: String) : ITokenType {
    OVER(">"),
    OVER_EQUAL(">="),
    LESS("<"),
    LESS_EQUAL("<="),
    EQUAL("="),
    NOT_EQUAL("<>")
}