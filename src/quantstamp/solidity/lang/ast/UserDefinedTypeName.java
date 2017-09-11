package quantstamp.solidity.lang.ast;

import java.util.List;

// UserDefinedTypeName = Identifier ( '.' Identifier )*

public final class UserDefinedTypeName extends Node {

  public final List<Identifier> identifiers;

  public UserDefinedTypeName(final List<Identifier> elems) {
    identifiers = elems;
  }

}
