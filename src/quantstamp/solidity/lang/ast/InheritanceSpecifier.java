package quantstamp.solidity.lang.ast;

import java.util.List;

// InheritanceSpecifier = UserDefinedTypeName ( '(' Expression ( ',' Expression )* ')' )?

public final class InheritanceSpecifier extends Node {

  public final UserDefinedTypeName userDefinedTypeName;
  public final List<Expression> expressions;

  public InheritanceSpecifier(final UserDefinedTypeName udtn, final List<Expression> exprs) {
    userDefinedTypeName = udtn;
    expressions = exprs;
  }

}
