package quantstamp.solidity.lang.ast;

// ArrayTypeName = TypeName '[' Expression? ']'

public final class ArrayTypeName extends Node {
  public final TypeName typeName;
  public final Expression expression;

  public ArrayTypeName(final TypeName typeName, final Expression expression) {
    this.expression = expression;
    this.typeName = typeName;
  }
}
