package backend.model.parser;

import backend.model.tokenizer.Symbol;
import backend.model.tokenizer.SymbolToken;

enum OperatorSymbol {
  ADDITION,
  SUBTRACTION,
  MUL,
  DIV,
  MOD,
  POWER
}

public class Operator {
  private final OperatorSymbol op;

  public Operator(OperatorSymbol op) {
    this.op = op;
  }

  public static Operator fromSymbolToken(SymbolToken symbolToken) {
    if (symbolToken.symbol == Symbol.PLUS) {
      return new Operator(OperatorSymbol.ADDITION);
    }
    if (symbolToken.symbol == Symbol.MINUS) {
      return new Operator(OperatorSymbol.SUBTRACTION);
    }
    if (symbolToken.symbol == Symbol.MUL) {
      return new Operator(OperatorSymbol.MUL);
    }
    if (symbolToken.symbol == Symbol.DIV) {
      return new Operator(OperatorSymbol.DIV);
    }
    if (symbolToken.symbol == Symbol.MOD) {
      return new Operator(OperatorSymbol.MOD);
    }
    if (symbolToken.symbol == Symbol.POWER) {
      return new Operator(OperatorSymbol.POWER);
    }
    
    return null;
  }
}
