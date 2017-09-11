package quantstamp.solidity.lang.ast;

// VariableDeclaration = TypeName StorageLocation? Identifier

public final class VariableDeclaration extends Node {
  public final TypeName typeName;
  public final StorageLocation storageLocation;
  public final Identifier identifier;

  public VariableDeclaration(final TypeName typeName, StorageLocation storageLocation,
      Identifier identifier) {
    this.typeName = typeName;
    this.storageLocation = storageLocation;
    this.identifier = identifier;
  }
}
