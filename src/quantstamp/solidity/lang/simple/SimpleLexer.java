package quantstamp.solidity.lang.simple;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import quantstamp.solidity.lang.Lexer;
import quantstamp.solidity.lang.exception.BadSyntaxException;

/**
 * Implementation of a "simple" lexer for Solidity.
 */
public final class SimpleLexer implements Lexer {

  private static String[] keywordArr = new String[] {
      // reserved keywords
      "abstract", "address", "after", "anonymous", "as", "assembly", "bool", "break", "case",
      "catch", "constant", "continue", "contract", "days", "default", "do", "enum", "event",
      "ether", "external", "false", "final", "finney", "fixed", "for", "from", "function", "hex",
      "hours", "import", "in", "indexed", "inline", "interface", "internal", "if", "is", "let",
      "library", "mapping", "match", "memory", "minutes", "modifier", "new", "null", "payable",
      "pragma", "private", "public", "pure", "of", "relocatable", "return", "returns", "seconds",
      "solidity", "static", "storage", "string", "struct", "switch", "szabo", "throw", "true",
      "try", "type", "typeof", "ufixed", "using", "var", "view", "weeks", "wei", "while", "years",

      // integer types
      "int", "int8", "int16", "int24", "int32", "int40", "int48", "int56", "int64", "int72",
      "int80", "int88", "int96", "int104", "int112", "int120", "int128", "int136", "int144",
      "int152", "int160", "int168", "int176", "int184", "int192", "int200", "int208", "int216",
      "int224", "int232", "int240", "int248", "int256",

      // uint types
      "uint", "uint8", "uint16", "uint24", "uint32", "uint40", "uint48", "uint56", "uint64",
      "uint72", "uint80", "uint88", "uint96", "uint104", "uint112", "uint120", "uint128", "uint136",
      "uint144", "uint152", "uint160", "uint168", "uint176", "uint184", "uint192", "uint200",
      "uint208", "uint216", "uint224", "uint232", "uint240", "uint248", "uint256",

      // byte types
      "byte", "bytes", "bytes1", "bytes2", "bytes3", "bytes4", "bytes5", "bytes6", "bytes7",
      "bytes8", "bytes9", "bytes10", "bytes11", "bytes12", "bytes13", "bytes14", "bytes15",
      "bytes16", "bytes17", "bytes18", "bytes19", "bytes20", "bytes21", "bytes22", "bytes23",
      "bytes24", "bytes25", "bytes26", "bytes27", "bytes28", "bytes29", "bytes30", "bytes31",
      "bytes32"};

  /** A collection of all reserved keywords */
  private static Collection<String> keywords = new HashSet<String>(Arrays.asList(keywordArr));

  /**
   * The type of a token recognizable by the lexer.
   */
  public static enum Type {
    T_ATOM, T_LBRACE, T_RBRACE, T_INTEGER, T_FLOAT, T_SEMICOLON, T_LPAREN, T_RPAREN,
  };

  /**
   * Data structure for a token that is recognized during the lexing procedure.
   */
  public final static class Token {
    public int line;
    public int column;
    public Type type;
    public String text;
    public BigInteger bigIntVal;
    public Float floatVal;

    @Override
    public String toString() {
      return text;
    }
  }

  // instance variables
  private final String input;
  private int currentPos = 0;
  private int line = 0;
  private int col = 0;
  private final Token token = new Token();

  /**
   * Constructs a new SimpleLexer instance to recognize the specified input.
   * 
   * @param input the input to be recognized by the lexer
   */
  public SimpleLexer(final String input) {
    this.input = input;
    nextToken();
  }

  /**
   * Advances the lexer to the next position/column.
   */
  private void advance() {
    currentPos++;
    col++;
  }

  /**
   * Processes the next token, or throws an exception if none can be parsed.
   */
  private void nextToken() {
    token.line = line;
    token.column = col;
    while (currentPos < input.length()) {
      char ch = input.charAt(currentPos);
      switch (ch) {
        case ' ': {
          advance();
          break;
        }
        case '\t': {
          advance();
          break;
        }
        case '\n': {
          currentPos++;
          line++;
          col = 0;
          break;
        }
        case '{': {
          token.type = Type.T_LBRACE;
          token.text = "{";
          advance();
          return;
        }
        case '}': {
          token.type = Type.T_RBRACE;
          token.text = "}";
          advance();
          return;
        }
        case ';': {
          token.type = Type.T_SEMICOLON;
          token.text = ";";
          advance();
          return;
        }
        case '(': {
          token.type = Type.T_LPAREN;
          token.text = "(";
          advance();
          return;
        }
        case ')': {
          token.type = Type.T_RPAREN;
          token.text = ")";
          advance();
          return;
        }
        default: {
          if (Character.isDigit(ch)) {
            final Object num = getNumericToken();
            if (num instanceof Integer) {
              token.type = Type.T_INTEGER;
              token.bigIntVal = (BigInteger) num;
            } else if (num instanceof Float) {
              token.type = Type.T_FLOAT;
              token.floatVal = (Float) num;
            } else {
              assert false; // should not reach this line!
            }
          } else {
            final String word = getAlphabeticToken();
            token.type = Type.T_ATOM;
            token.text = word;
          }
          return;
        }
      }
    }
  }

  /**
   * Returns an alphabetic token starting at the current position. The input is consumed until a
   * non-letter is encountered. The underscore character is permitted.
   * 
   * @return an alphabetic token read from the input
   */
  private String getAlphabeticToken() {
    int j = currentPos;
    for (; j < input.length();) {
      final char ch = input.charAt(j);
      if (Character.isLetter(ch) || ch == '_') {
        j++;
      } else {
        break;
      }
    }
    final String word = input.substring(currentPos, j);
    currentPos += word.length();
    col += word.length();
    return word;
  }

  /**
   * Returns a numerical token starting at the current position. The input is consumed until a
   * non-digit is encountered. Supports recognizing floating point numbers, including those with the
   * "f" suffix.
   * 
   * @return an alphabetic token read from the input
   */
  private Object getNumericToken() {
    boolean isFloat = false;
    int j = currentPos;
    for (; j < input.length();) {
      final char ch = input.charAt(j);
      if (Character.isDigit(ch)) {
        j++;
      } else if (ch == '.') {
        isFloat = true;
        j++;
      } else {
        break;
      }
    }
    if (isFloat && j + 1 < input.length()) {
      // 'f' at the end of a floating point number
      if (input.charAt(j + 1) == 'f') {
        j++;
      }
    }
    final String number = input.substring(currentPos, j);
    currentPos += number.length();
    col += number.length();
    if (isFloat) {
      return Float.parseFloat(number);
    } else {
      return Integer.parseInt(number);
    }
  }

  @Override
  public String eatKeyword(final String keyword) {
    if (!matchKeyword(keyword)) {
      throw new BadSyntaxException(token.line, token.column);
    }
    return afterEat();
  }

  @Override
  public String eatIdentifier() {
    if (!matchIdentifier()) {
      throw new BadSyntaxException(token.line, token.column);
    }
    return afterEat();
  }

  @Override
  public String eatLeftCurlyBrace() {
    if (!matchLeftCurlyBrace()) {
      throw new BadSyntaxException(token.line, token.column);
    }
    return afterEat();
  }

  @Override
  public String eatRightCurlyBrace() {
    if (!matchRightCurlyBrace()) {
      throw new BadSyntaxException(token.line, token.column);
    }
    return afterEat();
  }

  @Override
  public String eatSemicolon() {
    if (!matchSemicolon()) {
      throw new BadSyntaxException(token.line, token.column);
    }
    return afterEat();
  }

  @Override
  public String eatLeftParenthesis() {
    if (!matchLeftParenthesis()) {
      throw new BadSyntaxException(token.line, token.column);
    }
    return afterEat();
  }

  @Override
  public String eatRightParenthesis() {
    if (!matchRightParenthesis()) {
      throw new BadSyntaxException(token.line, token.column);
    }
    return afterEat();
  }

  /**
   * This is a convenience function to be called after an "eat" is performed. It saves and returns
   * the current token text, and also advances to the next token
   * 
   * @return the text of the current token (prior to advancing to the next one)
   */
  private String afterEat() {
    final String text = token.text;
    nextToken();
    return text;
  }

  @Override
  public boolean matchLeftParenthesis() {
    return token.type == Type.T_LPAREN;
  }

  @Override
  public boolean matchRightParenthesis() {
    return token.type == Type.T_RPAREN;
  }

  @Override
  public boolean matchSemicolon() {
    return token.type == Type.T_SEMICOLON;
  }

  @Override
  public boolean matchKeyword(String keyword) {
    return token.type == Type.T_ATOM && token.text.equals(keyword);
  }

  @Override
  public boolean matchIdentifier() {
    return token.type == Type.T_ATOM && !keywords.contains(token.text);
  }

  @Override
  public boolean matchLeftCurlyBrace() {
    return token.type == Type.T_LBRACE;
  }

  @Override
  public boolean matchRightCurlyBrace() {
    return token.type == Type.T_RBRACE;
  }

}
