package quantstamp.solidity.lang.ast;

import java.util.List;

// FunctionTypeName = 'function' TypeNameList ( 'internal' | 'external' | StateMutability )*
// ( 'returns' TypeNameList )?

public final class FunctionTypeName extends Node {

  public static enum FunctionVisibility {
    INTERNAL, EXTERNAL
  };

  public final TypeNameList typeNameList;
  public final List<FunctionVisibility> funcVisList;
  public final List<StateMutability> stateMutList;
  public final TypeNameList returnsTypeNameList;

  public FunctionTypeName(final TypeNameList typeNameList, final FunctionVisibility funcVis,
      final List<FunctionVisibility> funcVisList, final List<StateMutability> stateMutList,
      final TypeNameList returnsTypeNameList) {
    this.typeNameList = typeNameList;
    this.funcVisList = funcVisList;
    this.stateMutList = stateMutList;
    this.returnsTypeNameList = returnsTypeNameList;
  }

}
