package quantstamp.solidity.lang.ast;

import java.util.List;

// ContractDefinition = ( 'contract' | 'library' | 'interface' ) Identifier
// ( 'is' InheritanceSpecifier (',' InheritanceSpecifier )* )?
// '{' ContractPart* '}


public final class ContractDefinition extends Node {

  public enum ContractDefinitionType {
    CONTRACT, LIBRARY, INTERFACE;

    @Override
    public String toString() {
      switch (this) {
        case CONTRACT:
          return "contract";
        case LIBRARY:
          return "library";
        case INTERFACE:
          return "interface";
        default:
          throw new IllegalArgumentException();
      }
    }
  };

  public final ContractDefinitionType contractType;
  public final Identifier identifier;
  public final List<InheritanceSpecifier> inheritanceSpecifiers;
  public final ContractPart contractPart;

  public ContractDefinition(final ContractDefinitionType type, final Identifier id,
      final List<InheritanceSpecifier> lst, final ContractPart c) {
    contractType = type;
    identifier = id;
    inheritanceSpecifiers = lst;
    contractPart = c;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();

    sb.append(contractType);
    sb.append(" ");
    sb.append(identifier);

    if (inheritanceSpecifiers != null) {
      final int lastIndex = inheritanceSpecifiers.size() - 1;
      if (lastIndex >= 0) {
        sb.append(" is ");
        for (int i = 0; i < lastIndex; i++) {
          sb.append(inheritanceSpecifiers.get(i));
          sb.append(", ");
        }
        sb.append(inheritanceSpecifiers.get(lastIndex));
      }
    }

    sb.append("\n");
    sb.append("{\n");

    if (contractPart != null) {
      sb.append(contractPart);
    }

    sb.append("}\n");
    return sb.toString();
  }

}
