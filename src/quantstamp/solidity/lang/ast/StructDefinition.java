package quantstamp.solidity.lang.ast;

import java.util.List;

// StructDefinition = 'struct' Identifier '{'
// ( VariableDeclaration ';' (VariableDeclaration ';')* )? '}'

public final class StructDefinition extends Node {
  public final Identifier identifier;
  public final List<VariableDeclaration> varDecls;

  public StructDefinition(final Identifier id, List<VariableDeclaration> vars) {
    identifier = id;
    varDecls = vars;
  }
}
