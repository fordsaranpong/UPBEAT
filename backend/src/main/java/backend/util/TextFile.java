package backend.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFile {
  public final String text;

  public TextFile(String filename) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    String line = reader.readLine();
    while (line != null) {
      sb.append(line);
      sb.append(System.lineSeparator());
      line = reader.readLine();
    }
    reader.close();
    text = sb.toString();
  }
}
