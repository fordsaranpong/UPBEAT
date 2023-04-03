package backend.model.parser;

import java.util.ArrayList;
import java.util.List;

public class Expression {
  private List<Operand> operands;
  private List<Operator> operators;

  public Expression(Operand intiOperand) {
    this.operands = new ArrayList<>();
    this.operators = new ArrayList<>();

    this.operands.add(intiOperand);
  }

  public void add(Operator op, Operand operand) {
    this.operands.add(operand);
    this.operators.add(op);
  }
}
