package backend.model.parser;

import java.util.ArrayList;
import java.util.List;

import backend.model.tokenizer.*;

public class Parser {
  private List<Token> input;
  private int position;
  private List<Statement> statements;

  public Parser(List<Token> input) {
    this.input = input;
    this.position = 0;
    this.statements = new ArrayList<Statement>();
  }

  public List<Statement> parse() {
    while (position < input.size()) {
      Token token = input.get(position);

      if (token instanceof IdentToken) {
        Statement stmt = parseAssigmentStatement();
        statements.add(stmt);
      } else if (token instanceof KeywordToken) {
        Statement stmt = parseKeywordStatement();
        statements.add(stmt);
      } else {
        position++;
      }
    }

    return this.statements;
  }

  private AssignmentStatement parseAssigmentStatement() {
    Token fst = input.get(position);
    Token snd = input.get(position + 1);

    // TODO: add ident without assign (=)
    if (fst instanceof IdentToken && snd instanceof SymbolToken && ((SymbolToken) snd).symbol == Symbol.ASSIGN) {
      position += 2;

      IdentToken ident = (IdentToken) fst;
      Expression expr = parseExpression();

      return new AssignmentStatement(ident.ident, expr);
    }
    else {
      throw new Error("error at assignment statement");
    }
  }

  private Statement parseKeywordStatement() {
    while (position < input.size()) {
      KeywordToken token = (KeywordToken) input.get(position);
      
      if (token.keyword == Keyword.DONE || token.keyword == Keyword.RELOCATE) {
        position++;
        return new ActionStatement(token.keyword, null, null);
      } else if (token.keyword == Keyword.MOVE) {
        position++;
        KeywordToken nextToken = (KeywordToken) input.get(position);

        if (nextToken.isDirection()) {
          position++;
          return new ActionStatement(token.keyword, nextToken.keyword, null);
        } else {
          throw new Error("error at parsing move keyword unknown direction");
        }
      } else if (token.keyword == Keyword.INVEST || token.keyword == Keyword.COLLECT) {
        position++;
        Expression expr = parseExpression();

        return new ActionStatement(token.keyword, null, expr);
      } else if (token.keyword == Keyword.SHOOT) {
        position++;
        KeywordToken nextToken = (KeywordToken) input.get(position);
        position++;
        Expression expr = parseExpression();

        if (nextToken.isDirection()) {
          position++;
          return new ActionStatement(token.keyword, nextToken.keyword, expr);
        } else {
          throw new Error("error at parsing shoot keyword unknown direction");
        }
      } else {
        throw new Error(String.format("error %d at parsing keyword statement %s unknonw keyword", position, token.keyword));
      }
    }

    throw new Error("error");
  }

  private Expression parseExpression() {
    Expression expr = null;

    Operand tmpOperand = null;
    Operator tmpOperator = null;
    while (position < input.size()) {
      Token token = input.get(position);

      // pasrse expr
      if (token instanceof IdentToken) {
        IdentToken ident = (IdentToken) token;

        tmpOperand = new IdentOperand(ident.ident);
      } else if (token instanceof LiteralToken) {
        LiteralToken literal = (LiteralToken) token;

        tmpOperand = new LiteralOperand(literal.value);
      } else if (token instanceof KeywordToken) {
        Keyword keyword = ((KeywordToken) token).keyword;

        if (keyword == Keyword.OPPONENT) {
          tmpOperand = new InfoOperand(keyword, null);
        } else if (keyword == Keyword.NEARBY) {
          position++;
          KeywordToken nextToken = (KeywordToken) input.get(position);

          if (nextToken.isDirection()) {
            tmpOperand = new InfoOperand(keyword, nextToken.keyword);
          } else {
            throw new Error("error at parsing expression unknown direction");
          }
        } else {
          throw new Error(String.format("error %d at parsing expression %s unknown keyword", position, keyword));
        }
      } else if (token instanceof SymbolToken) {
        SymbolToken sym = (SymbolToken) token;

        if (sym.isOperator()) {
          tmpOperator = Operator.fromSymbolToken(sym);
        } else if (sym.symbol == Symbol.END) {
          return expr;
        } else {
          throw new Error(String.format("error %d at parsing expression %s symbol not operator", position, sym.symbol));
        }
      } else {
        throw new Error("error at parsing expression");
      }

      // append expr
      if (expr == null && tmpOperand != null) {
        if (tmpOperator != null) {
          throw new Error("error at parsing expression operator without operand");
        }

        expr = new Expression(tmpOperand);

        tmpOperand = null;
      } else if (expr != null && tmpOperand != null && tmpOperator != null) {
        expr.add(tmpOperator, tmpOperand);

        tmpOperand = null;
        tmpOperator = null;
      }

      position++;
    }

    return expr;
  }
}
