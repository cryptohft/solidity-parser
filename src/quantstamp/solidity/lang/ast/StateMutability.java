package quantstamp.solidity.lang.ast;

// StateMutability = 'pure' | 'constant' | 'view' | 'payable'

public final class StateMutability extends Node {

  public static enum StateMutabilityValue {
    PURE, CONSTANT, VIEW, PAYABLE
  }

  final StateMutabilityValue val;

  public StateMutability(final StateMutabilityValue val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return val.toString();
  }

}
