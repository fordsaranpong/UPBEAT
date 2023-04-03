package backend.model.region;

import backend.model.config.Config;
import backend.model.player.Player;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Tile {
  @JsonProperty("coord")
  public final Coord coord;
  @JsonProperty("maxDeposit")
  public final double maxDeposit;
  @JsonProperty("baseInterestRate")
  public final double baseInterestRate;
  
  @JsonProperty("owningTurnCount")
  private long owningTurnCount;
  @JsonProperty("ownerName")
  private String ownerName;
  private Player owner;
  @JsonProperty("isCityCenter")
  private boolean isCityCenter;
  @JsonProperty("interestRate")
  private double interestRate;
  @JsonProperty("deposit")
  private double deposit;
  
  public Tile(long row, long col, Config config) {
    this.coord = new Coord(row, col);
    this.baseInterestRate = config.interestPct;
    this.interestRate = config.interestPct;
    this.maxDeposit = config.maxDep;
  }

  public void setOnwer(Player player) {
    this.ownerName = player.name;
    this.owner = player;
  }

  public void setCityCenter() {
    this.isCityCenter = true;
  }

  public void removeCityCenter() {
    this.isCityCenter = false;
  }

  public void setDeposit(double deposit) {
    this.deposit = deposit;
  }

  public void forwardTurn() {
    owningTurnCount += 1;
  }
  
  public void forwardDeposit() {
    deposit += deposit * interestRate / 100.0;
  }

  public void forwardInterest() {
    interestRate = baseInterestRate * Math.log10(deposit) * Math.log(owningTurnCount);
  }

  public String toJson() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(this);
  }
}
