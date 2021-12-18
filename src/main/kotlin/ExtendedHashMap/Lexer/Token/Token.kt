package ExtendedHashMap.Lexer.Token

import ExtendedHashMap.Lexer.Token.Interfaces.ITokenType

class Token(val type: ITokenType, val value: Int?) {
    override fun toString(): String {
        return "Token($type, $value)"
    }
}