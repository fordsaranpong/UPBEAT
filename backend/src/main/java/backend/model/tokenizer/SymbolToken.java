package backend.model.tokenizer;

public class SymbolToken extends Token {
  public final Symbol symbol;

  public SymbolToken(Symbol symbol) {
    super();

    this.symbol = symbol;
  }

  public static Symbol match(String word) {
    if (word.equals("(")) {
      return Symbol.OPEN_PAR;
    }
    if (word.equals(")")) {
      return Symbol.CLOSE_PAR;
    }
    if (word.equals("{")) {
      return Symbol.OPEN_BRACE;
    }
    if (word.equals("}")) {
      return Symbol.CLOSE_BRACE;
    }
    if (word.equals("=")) {
      return Symbol.ASSIGN;
    }
    if (word.equals("+")) {
      return Symbol.PLUS;
    }
    if (word.equals("-")) {
      return Symbol.MINUS;
    }
    if (word.equals("/")) {
      return Symbol.DIV;
    }
    if (word.equals("*")) {
      return Symbol.MUL;
    }
    if (word.equals("%")) {
      return Symbol.MOD;
    }
    if (word.equals("^")) {
      return Symbol.POWER;
    }
    if (word.equals("\n")) {
      return Symbol.END;
    }

    return null;
  }

  public boolean isOperator() {
    return this.symbol == Symbol.PLUS
      || this.symbol == Symbol.MINUS
      || this.symbol == Symbol.MUL
      || this.symbol == Symbol.DIV
      || this.symbol == Symbol.POWER
      || this.symbol == Symbol.MOD;
  }
}
