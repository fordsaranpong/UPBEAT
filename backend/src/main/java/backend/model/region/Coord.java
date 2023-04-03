package backend.model.region;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Coord implements Cloneable {
  @JsonProperty("row")
  private final long row;
  @JsonProperty("col")
  private final long col;

  public Coord(long row, long col) {
    this.row = row;
    this.col = col;
  }

  public String toString() {
    return String.format("%d,%d", row, col);
  }

  public static Coord fromString(String s) {
    String[] tmp = s.split(",");
    long row = Long.parseLong(tmp[0]);
    long col = Long.parseLong(tmp[1]);

    return new Coord(row, col);
  }

  @Override
  public Coord clone() {
    return (Coord) new Coord(row, col);
  }

  public String toJson() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(this);
  }
}
