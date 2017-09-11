package quantstamp.solidity.lang.ast;

// ContractPart = StateVariableDeclaration | UsingForDeclaration
// | StructDefinition | ModifierDefinition | FunctionDefinition
// | EventDefinition | EnumDefinition


public final class ContractPart extends Node {
  public final StructDefinition structDef;
  public final StateVariableDeclaration stateVarDecl;
  public final ModifierDefinition modifierDef;

  public ContractPart(final StructDefinition structDef) {
    this.structDef = structDef;
    this.stateVarDecl = null;
    this.modifierDef = null;
  }

  public ContractPart(final StateVariableDeclaration stateVarDecl) {
    this.stateVarDecl = stateVarDecl;
    this.structDef = null;
    this.modifierDef = null;
  }

  public ContractPart(final ModifierDefinition modifierDef) {
    this.stateVarDecl = null;
    this.structDef = null;
    this.modifierDef = modifierDef;
  }
}
