package quantstamp.solidity.lang.ast.statement;

import quantstamp.solidity.lang.ast.Expression;

// WhileStatement = 'while' '(' Expression ')' Statement

public final class WhileStatement extends Statement {
  public final Expression expr;
  public final Statement stmt;

  public WhileStatement(final Expression expr, final Statement stmt) {
    this.expr = expr;
    this.stmt = stmt;
  }

  @Override
  public String toString() {
    return "while (" + expr + ") " + stmt;
  }
}
