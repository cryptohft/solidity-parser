package quantstamp.solidity.lang.ast;

// Mapping = 'mapping' '(' ElementaryTypeName '=>' TypeName ')'

public final class Mapping extends Node {
  public final ElementaryTypeName elemTypeName;
  public final TypeName typeName;

  public Mapping(final ElementaryTypeName elemTypeName, final TypeName typeName) {
    this.elemTypeName = elemTypeName;
    this.typeName = typeName;
  }

  @Override
  public String toString() {
    return "mapping (" + elemTypeName + " => " + typeName + ")";
  }
}
