package backend.model.player;

import java.util.HashMap;
import java.util.Map;

import backend.model.region.Coord;
import backend.model.tokenizer.Keyword;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Player {
  @JsonProperty("name")
  public final String name;

  @JsonProperty("cityCenterCoord")
  private Coord cityCenterCoord;
  @JsonProperty("cityCrewCoord")
  private Coord cityCrewCoord;
  @JsonProperty("isInit")
  private boolean isInit = false;
  @JsonProperty("budget")
  private double budget = 0.0;
  @JsonProperty("vars")
  private Map<String, Long> vars = new HashMap<>();

  public Player(String name, Coord coord, double budget) {
    this.name = name;
    this.cityCenterCoord = coord.clone();
    this.cityCrewCoord = coord.clone();
    this.budget = budget;
  }

  public void getVar(String name) {

  }

  public void addVar(String name, long value) {

  }

  public void execOpponent() {

  }

  public void execNearby(Keyword direction) {

  }

  public String toJson() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(this);
  }
}
