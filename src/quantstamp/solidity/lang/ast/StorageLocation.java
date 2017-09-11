package quantstamp.solidity.lang.ast;

// StorageLocation = 'memory' | 'storage'

public final class StorageLocation extends Node {

  public static enum StorageLocationType {
    MEMORY, STORAGE
  }

  public final StorageLocationType type;

  public StorageLocation(final StorageLocationType type) {
    this.type = type;
  }

}
