package backend.model.tokenizer;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
  private String input;
  private int position;
  private List<Token> tokens;

  public Tokenizer(String input) {
    this.input = input;
    this.position = 0;
    this.tokens = new ArrayList<Token>();
  }

  public List<Token> tokenize() {
    while (position < input.length()) {
      char c = input.charAt(position);

      if (Character.isLetter(c) || c == '_') {
        // Identifier or keyword
        Token token = parseIdentifierOrKeyword();
        tokens.add(token);
      } else if (Character.isDigit(c)) {
        // Number literal
        Token token = parseNumberLiteral();
        tokens.add(token);
      } else if (isSymbol(c)) {
        // Symbol
        Symbol symbol = SymbolToken.match(String.valueOf(c));
        Token token = new SymbolToken(symbol);
        tokens.add(token);
        position++;
      } else {
        // Unknown character
        position++;
      }
    }

    return tokens;
  }

  private Token parseIdentifierOrKeyword() {
    StringBuilder sb = new StringBuilder();

    while (position < input.length()) {
      char c = input.charAt(position);

      if (Character.isLetterOrDigit(c) || c == '_') {
        sb.append(c);
        position++;
      } else {
        break;
      }
    }

    String token = sb.toString();
    Keyword keywordResult = KeywordToken.match(token);

    if (keywordResult != null) {
      return new KeywordToken(keywordResult);
    } else {
      return new IdentToken(token);
    }
  }

  private Token parseNumberLiteral() {
    StringBuilder sb = new StringBuilder();

    while (position < input.length()) {
      char c = input.charAt(position);

      if (Character.isDigit(c) || c == '.') {
        sb.append(c);
        position++;
      } else {
        break;
      }
    }

    return new LiteralToken(sb.toString());
  }

  private boolean isSymbol(char c) {
    return SymbolToken.match(String.valueOf(c)) != null;
  }
}
