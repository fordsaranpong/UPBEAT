package backend.model.parser;

public class AssignmentStatement extends Statement {
  private String ident;
  private Expression expr;

  public AssignmentStatement(String ident, Expression expr) {
    this.ident = ident;
    this.expr = expr;
  }
}
