package backend.model.region;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import backend.model.config.Config;

public class Grid {
  @JsonProperty("tileMap")
  private Map<String, Tile> tileMap;

  public Grid(Config config) {
    Map<String, Tile> tileMap = new HashMap<>();
    for (long col = 1; col <= config.n; col++) {
      for (long row = 1; row <= config.m; row++) {
        Tile tile = new Tile(row, col, config);

        tileMap.put(tile.coord.toString(), tile);
      }
    }

    this.tileMap = tileMap;
  }

  public Tile getTile(Coord coord) {
    return this.tileMap.get(coord.toString());
  }

  public Tile getTile(long row, long col) {
    return this.tileMap.get(new Coord(row, col).toString());
  }

  public String toJson() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(this);
  }
}
