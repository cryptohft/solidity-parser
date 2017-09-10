package quantstamp.solidity.lang;

/**
 * An interface for the Solidity lexer.
 */
public interface Lexer {

  boolean matchKeyword(String w);

  public boolean matchIdentifier();

  boolean matchLeftCurlyBrace();

  boolean matchRightCurlyBrace();

  boolean matchLeftParenthesis();

  boolean matchRightParenthesis();

  boolean matchSemicolon();

  String eatKeyword(String w);

  String eatIdentifier();

  String eatLeftCurlyBrace();

  String eatRightCurlyBrace();

  String eatLeftParenthesis();

  String eatRightParenthesis();

  String eatSemicolon();

}
