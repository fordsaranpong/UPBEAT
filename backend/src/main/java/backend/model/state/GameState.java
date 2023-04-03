package backend.model.state;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import backend.model.config.*;
import backend.model.player.*;
import backend.model.region.*;
import backend.util.Common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class GameState {
  @JsonProperty("config")
  private final Config config;
  @JsonProperty("turnCount")
  private long turnCount;
  @JsonProperty("playerTurnIndex")
  private long playerTurnIndex;
  @JsonProperty("grid")
  private Grid grid;
  @JsonProperty("players")
  private List<Player> players;

  public GameState(String[] playerNames, Config config) {
    this.turnCount = 0;
    this.playerTurnIndex = 0;
    this.config = config;
    this.grid = new Grid(config);

    Deque<String> randCoordPool = startRandomly(playerNames.length, config.m, config.n);

    List<Player> players = new ArrayList<>();
    for (String playerName : playerNames) {
      String stringCoord = randCoordPool.pop();
      Coord coord = Coord.fromString(stringCoord);

      // init player
      Player player = new Player(playerName, coord, config.initBudget);

      // init tile
      Tile tile = grid.getTile(coord);
      tile.setOnwer(player);
      tile.setCityCenter();
      tile.setDeposit(config.initCenterDep);

      players.add(player);
    }

    this.players = players;
  }

  public Deque<String> startRandomly(long nPlayer, long m, long n) {
    Deque<String> deque = new ArrayDeque<>();

    for (long i = 0; i < nPlayer; i++) {
      Coord coord;
      do {
        long randRow = Common.getRandomNumberInRange(1, (int) m);
        long randCol = Common.getRandomNumberInRange(1, (int) n);

        coord = new Coord(randRow, randCol);
      } while (deque.contains(coord.toString()));

      deque.push(coord.toString());
    }

    return deque;
  }

  public String toJson() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(this);
  }
}
