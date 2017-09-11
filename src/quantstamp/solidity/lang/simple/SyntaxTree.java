package quantstamp.solidity.lang.simple;

import quantstamp.solidity.lang.ast.Node;

public class SyntaxTree {

  public Node root;

  @Override
  public String toString() {
    return root.toString();
  }
}
