package quantstamp.solidity.lang.ast.statement;

import quantstamp.solidity.lang.ast.Expression;

// IfStatement = 'if' '(' Expression ')' Statement ( 'else' Statement )?

public final class IfStatement extends Statement {
  public final Expression expr;
  public final Statement stmt;
  public final Statement elseStmt;

  public IfStatement(final Expression expr, final Statement stmt) {
    this.expr = expr;
    this.stmt = stmt;
    this.elseStmt = null;
  }

  public IfStatement(final Expression expr, final Statement stmt, final Statement elseStmt) {
    this.expr = expr;
    this.stmt = stmt;
    this.elseStmt = elseStmt;
  }

  @Override
  public String toString() {
    if (elseStmt == null)
      return "if (" + expr + ") {" + stmt + "}\n";
    else
      return "if (" + expr + ") {" + stmt + "} else {" + elseStmt + "}\n";
  }
}
