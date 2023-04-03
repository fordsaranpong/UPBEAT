package backend.model.tokenizer;

public class IdentToken extends Token {
  public final String ident;

  public IdentToken(String word) {
    super();

    this.ident = word;
  }
}
