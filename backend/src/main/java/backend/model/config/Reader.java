package backend.model.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Reader {
  private final Map<String, String> data;

  public Reader(String filename) throws IOException {
    data = new HashMap<>();
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    String line = reader.readLine();
    while (line != null) {
      String[] parts = line.split("=", 2);
      if (parts.length == 2) {
        data.put(parts[0], parts[1]);
      }
      line = reader.readLine();
    }
    reader.close();
  }

  public long getValue(String key) {
    String value = data.get(key);
    if (value != null) {
      return Long.parseLong(value);
    }
    throw new IllegalArgumentException("Key not found or value is not an integer: " + key);
  }
}
