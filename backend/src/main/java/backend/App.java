package backend;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import backend.model.config.*;
import backend.model.parser.Parser;
import backend.model.parser.Statement;
import backend.model.tokenizer.*;
import backend.util.TextFile;
import backend.model.state.*;

@SpringBootApplication
public class App 
{
    public static Config config;
    public static GameState gameState;

    public static void main(String[] args) throws IOException
    {
        TextFile textFile = new TextFile("src/main/resources/SampleCommand.txt");
        Reader r = new Reader("src/main/resources/ConfigurationFile.txt");
        App.config = new Config(r);

        List<Token> tokens = new Tokenizer(textFile.text).tokenize();
        List<Statement> stmts = new Parser(tokens).parse();

        for (Statement stmt : stmts) {
            System.out.println(stmt);
        }

        SpringApplication.run(App.class, args);
    }
}
