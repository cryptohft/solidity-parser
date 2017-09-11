package quantstamp.solidity.lang.simple;

import quantstamp.solidity.lang.Lexer;
import quantstamp.solidity.lang.Parser;
import quantstamp.solidity.lang.ast.ContractDefinition;
import quantstamp.solidity.lang.ast.Identifier;
import quantstamp.solidity.lang.ast.SourceUnit;

public class SimpleParser implements Parser {

  private final Lexer lex;

  public SimpleParser(final String input) {
    this.lex = new SimpleLexer(input);
  }

  @Override
  public SyntaxTree parse() {
    final SyntaxTree tree = new SyntaxTree();
    tree.root = getSourceUnit();
    return tree;
  }

  public SourceUnit getSourceUnit() {
    SourceUnit n = null;

    // Contract definition
    if (lex.matchKeyword("contract")) {
      ContractDefinition contractDef = getContractDefinition();
      n = new SourceUnit(contractDef);
    }

    return n;
  }

  private ContractDefinition getContractDefinition() {
    lex.eatKeyword("contract");
    final Identifier id = getIdentifier();
    lex.eatLeftCurlyBrace();
    lex.eatRightCurlyBrace();

    return new ContractDefinition(ContractDefinition.ContractDefinitionType.CONTRACT, id, null,
        null);
  }

  private Identifier getIdentifier() {
    return new Identifier(lex.eatIdentifier());
  }

}
