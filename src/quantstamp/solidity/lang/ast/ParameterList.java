package quantstamp.solidity.lang.ast;

import java.util.List;

// ParameterList = '(' ( TypeName Identifier? (',' TypeName Identifier?)* )? ')'

public final class ParameterList extends Node {

  public static class Param {
    public final TypeName typeName;
    public final Identifier identifier;

    public static Param create(final TypeName typeName) {
      return new Param(typeName);
    }

    public static Param create(final TypeName typeName, final Identifier identifier) {
      return new Param(typeName, identifier);
    }

    private Param(final TypeName typename) {
      this.typeName = typename;
      this.identifier = null;
    }

    private Param(final TypeName typename, final Identifier identifier) {
      this.typeName = typename;
      this.identifier = identifier;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder();
      sb.append(typeName);
      if (identifier != null) {
        sb.append(" ");
        sb.append(identifier);
      }
      return sb.toString();
    }
  }

  public final List<Param> parameters;

  public ParameterList(final List<Param> parameters) {
    this.parameters = parameters;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("(");
    final int lastIndex = parameters.size() - 1;
    if (lastIndex >= 0) {
      sb.append(parameters.get(0));
      for (int i = 1; i < lastIndex; i++) {
        sb.append(parameters.get(i) + ", ");
      }
      sb.append(parameters.get(lastIndex));
    }
    sb.append(")");
    return sb.toString();
  }
}
