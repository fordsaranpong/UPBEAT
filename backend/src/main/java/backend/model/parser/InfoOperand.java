package backend.model.parser;

import backend.model.tokenizer.Keyword;

public class InfoOperand extends Operand {
  private Keyword command;
  private Keyword direction;

  public InfoOperand(Keyword command, Keyword direction) {
    super();

    this.command = command;
    this.direction = direction;
  }
}
