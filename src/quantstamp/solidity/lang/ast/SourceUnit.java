package quantstamp.solidity.lang.ast;

// SourceUnit = (PragmaDirective | ImportDirective | ContractDefinition)*

public final class SourceUnit extends Node {
  public final ContractDefinition contractDef;
  // public final ImportDirective importDir;
  // public final PragmaDirective pragmaDir;

  public SourceUnit(final ContractDefinition contractDef) {
    this.contractDef = contractDef;
  }
  
  @Override
  public String toString() {
    if (contractDef != null) {
      return contractDef.toString();
    }
    else {
      return "";
    }
  }
}
