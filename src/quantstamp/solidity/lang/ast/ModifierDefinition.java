package quantstamp.solidity.lang.ast;

// ModifierDefinition = 'modifier' Identifier ParameterList? Block

public final class ModifierDefinition extends Node {
  public final Identifier identifier;
  public final ParameterList paramList;
  public final Block block;

  public ModifierDefinition(final Identifier identifier, final Block block) {
    this.identifier = identifier;
    this.paramList = null;
    this.block = block;
  }

  public ModifierDefinition(final Identifier identifier, final ParameterList paramList,
      final Block block) {
    this.identifier = identifier;
    this.paramList = paramList;
    this.block = block;
  }
}
