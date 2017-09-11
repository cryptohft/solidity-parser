package quantstamp.solidity.lang.ast.statement;

import quantstamp.solidity.lang.ast.Expression;
import quantstamp.solidity.lang.ast.ExpressionStatement;
import quantstamp.solidity.lang.ast.SimpleStatement;

// ForStatement = 'for' '(' (SimpleStatement)? ';' (Expression)? ';' (ExpressionStatement)? ')'
// Statement

public final class ForStatement extends Statement {
  public final SimpleStatement simpleStmt;
  public final Expression expr;
  public final ExpressionStatement exprStmt;
}
