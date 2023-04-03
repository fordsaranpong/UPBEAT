package backend.model.parser;

public class LiteralOperand extends Operand {
  private Double value;

  public LiteralOperand(Double value) {
    this.value = value;
  }
}
