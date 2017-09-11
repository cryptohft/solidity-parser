package quantstamp.solidity.lang.ast;

import quantstamp.solidity.lang.ast.statement.Statement;

// Block = '{' Statement* '}'

public final class Block extends Node {
  public final Statement statement;
  
  public Block(final Statement statement) {
    this.statement = statement;
  }
}
