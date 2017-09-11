package quantstamp.solidity.lang.ast;

// ContractPart = StateVariableDeclaration | UsingForDeclaration
// | StructDefinition | ModifierDefinition | FunctionDefinition
// | EventDefinition | EnumDefinition


public final class ContractPart extends Node {
  public final StructDefinition structDef;

  public ContractPart(final StructDefinition structDef) {
    this.structDef = structDef;
  }
}
