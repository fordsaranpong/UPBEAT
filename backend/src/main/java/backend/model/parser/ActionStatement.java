package backend.model.parser;

import backend.model.tokenizer.Keyword;

public class ActionStatement extends Statement {
  private final Keyword action;
  private final Keyword direction;
  private final Expression expr;

  public ActionStatement(Keyword action, Keyword direction, Expression expr) {
    this.action = action;
    this.direction = direction;
    this.expr = expr;
  }
}
