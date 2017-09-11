package quantstamp.solidity.lang.ast;

// StateVariableDeclaration = TypeName ( 'public' | 'internal' | 'private' | 'constant' )?
// Identifier ('=' Expression)? ';'

public final class StateVariableDeclaration extends Node {

  public static enum StateVariableVisibility {
    PUBLIC, INTERNAL, PRIVATE, CONSTANT
  };

  public final TypeName typeName;
  public final StateVariableVisibility vis;
  public final Identifier identifier;
  public final Expression expr;

  public StateVariableDeclaration(final TypeName typeName, final StateVariableVisibility vis,
      final Identifier identifier) {
    this.typeName = typeName;
    this.vis = vis;
    this.identifier = identifier;
    this.expr = null;
  }

  public StateVariableDeclaration(final TypeName typeName, final StateVariableVisibility vis,
      final Identifier identifier, final Expression expr) {
    this.typeName = typeName;
    this.vis = vis;
    this.identifier = identifier;
    this.expr = null;
  }

}
