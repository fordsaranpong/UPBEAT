package backend.model.tokenizer;

public class KeywordToken extends Token {
  public final Keyword keyword;

  public KeywordToken(Keyword keyword) {
    super();

    this.keyword = keyword;
  }

  public static Keyword match(String word) {
    if (word.equals("COLLECT".toLowerCase())) {
      return Keyword.COLLECT;
    }
    if (word.equals("DONE".toLowerCase())) {
      return Keyword.COLLECT;
    }
    if (word.equals("DOWN".toLowerCase())) {
      return Keyword.DOWN;
    }
    if (word.equals("DOWNLEFT".toLowerCase())) {
      return Keyword.DOWNLEFT;
    }
    if (word.equals("DOWNRIGHT".toLowerCase())) {
      return Keyword.DOWNRIGHT;
    }
    if (word.equals("ELSE".toLowerCase())) {
      return Keyword.ELSE;
    }
    if (word.equals("IF".toLowerCase())) {
      return Keyword.IF;
    }
    if (word.equals("INVEST".toLowerCase())) {
      return Keyword.INVEST;
    }
    if (word.equals("MOVE".toLowerCase())) {
      return Keyword.MOVE;
    }
    if (word.equals("NEARBY".toLowerCase())) {
      return Keyword.NEARBY;
    }
    if (word.equals("OPPONENT".toLowerCase())) {
      return Keyword.OPPONENT;
    }
    if (word.equals("RELOCATE".toLowerCase())) {
      return Keyword.RELOCATE;
    }
    if (word.equals("SHOOT".toLowerCase())) {
      return Keyword.SHOOT;
    }
    if (word.equals("THEN".toLowerCase())) {
      return Keyword.THEN;
    }
    if (word.equals("UP".toLowerCase())) {
      return Keyword.UP;
    }
    if (word.equals("UPLEFT".toLowerCase())) {
      return Keyword.UPLEFT;
    }
    if (word.equals("UPRIGHT".toLowerCase())) {
      return Keyword.UPRIGHT;
    }
    if (word.equals("WHILE".toLowerCase())) {
      return Keyword.WHILE;
    }

    return null;
  }

  public boolean isDirection() {
    return this.keyword == Keyword.UP
      || this.keyword == Keyword.DOWN
      || this.keyword == Keyword.UPLEFT
      || this.keyword == Keyword.UPRIGHT
      || this.keyword == Keyword.DOWNLEFT
      || this.keyword == Keyword.DOWNRIGHT;
  }
}
