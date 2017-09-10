package quantstamp.solidity.lang.simple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import quantstamp.solidity.lang.Lexer;

public class Driver {

  public static void main(String[] args) {
    try {
      final String path = args[0];

      // Read file contents into string
      final String input = new String(Files.readAllBytes(Paths.get(path)));

      // Use the lexer to consume tokens
      final Lexer lex = new SimpleLexer(input);
      System.out.println("keyword     : " + lex.eatKeyword("contract"));
      System.out.println("identifier  : " + lex.eatIdentifier());
      System.out.println("left curly  : " + lex.eatLeftCurlyBrace());
      System.out.println("right curly : " + lex.eatRightCurlyBrace());

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
