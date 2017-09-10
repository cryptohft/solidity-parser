package quantstamp.solidity.lang.exception;

@SuppressWarnings("serial")
public class BadSyntaxException extends RuntimeException {
  public BadSyntaxException(final int line, final int col) {
    super("Syntax error @ [" + line + ", " + col + "]");
  }
}
