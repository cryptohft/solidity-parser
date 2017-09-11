package quantstamp.solidity.lang.ast;

// TypeName = ElementaryTypeName
// | UserDefinedTypeName
// | Mapping
// | ArrayTypeName
// | FunctionTypeName

public final class TypeName extends Node {
  public final UserDefinedTypeName userDefinedTypeName;
  public final Mapping mapping;
  public final ArrayTypeName arrayTypeName;
  public final FunctionTypeName functionTypeName;

  public TypeName(final UserDefinedTypeName userDefinedTypeName) {
    this.userDefinedTypeName = userDefinedTypeName;
    this.mapping = null;
    this.arrayTypeName = null;
    this.functionTypeName = null;
  }

  public TypeName(final Mapping mapping) {
    this.userDefinedTypeName = null;
    this.mapping = mapping;
    this.arrayTypeName = null;
    this.functionTypeName = null;
  }

  public TypeName(final ArrayTypeName arrayTypeName) {
    this.userDefinedTypeName = null;
    this.mapping = null;
    this.arrayTypeName = arrayTypeName;
    this.functionTypeName = null;
  }

  public TypeName(final FunctionTypeName functionTypeName) {
    this.userDefinedTypeName = null;
    this.mapping = null;
    this.arrayTypeName = null;
    this.functionTypeName = functionTypeName;
  }
}
