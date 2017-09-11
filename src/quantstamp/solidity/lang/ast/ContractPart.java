package quantstamp.solidity.lang.ast;

// ContractPart = StateVariableDeclaration | UsingForDeclaration
// | StructDefinition | ModifierDefinition | FunctionDefinition
// | EventDefinition | EnumDefinition


public final class ContractPart extends Node {
  public final StructDefinition structDef;
  public final StateVariableDeclaration stateVarDecl;

  public ContractPart(final StructDefinition structDef) {
    this.structDef = structDef;
    this.stateVarDecl = null;
  }

  public ContractPart(final StateVariableDeclaration stateVarDecl) {
    this.stateVarDecl = stateVarDecl;
    this.structDef = null;
  }
}
