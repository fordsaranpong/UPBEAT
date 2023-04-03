package backend.model.tokenizer;

public class LiteralToken extends Token {
  public final Double value;

  public LiteralToken(String raw) {
    this.value = Double.parseDouble(raw);
  }
}
