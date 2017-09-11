package quantstamp.solidity.lang.ast;

// Identifier = [a-zA-Z_$] [a-zA-Z_$0-9]*

public final class Identifier extends Node {

  public final String text;

  public Identifier(final String txt) {
    text = txt;
  }

  @Override
  public String toString() {
    return text;
  }
}
