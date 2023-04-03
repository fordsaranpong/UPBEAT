package backend.model.config;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Config {
  /** the number of rows in the territory */
  public final long m;
  /** the number of columns in the territory */
  public final long n;
  /**
   * the number of minutes allowed for the initial construction plan specification
   */
  public final long initPlanMin;
  /**
   * the number of seconds allowed for the initial construction plan specification
   * (between 0 and 59 inclusive)
   */
  public final long initPlanSec;
  /** the initial budget */
  public final long initBudget;
  /** the initial city center deposit */
  public final long initCenterDep;
  /** the number of minutes allowed for the construction plan revisions */
  public final long planRevMin;
  /**
   * the number of seconds allowed for the construction plan revisions (between 0
   * and 59 inclusive)
   */
  public final long planRevSec;
  /** construction plan revision cost */
  public final long revCost;
  /** maximum deposit per region */
  public final long maxDep;
  /** interest rate percentage */
  public final long interestPct;

  public Config(Reader reader) {
    this.m = reader.getValue("m");
    this.n = reader.getValue("n");
    this.initPlanMin = reader.getValue("init_plan_min");
    this.initPlanSec = reader.getValue("init_plan_sec");
    this.initBudget = reader.getValue("init_budget");
    this.initCenterDep = reader.getValue("init_center_dep");
    this.planRevMin = reader.getValue("plan_rev_min");
    this.planRevSec = reader.getValue("plan_rev_sec");
    this.revCost = reader.getValue("rev_cost");
    this.maxDep = reader.getValue("max_dep");
    this.interestPct = reader.getValue("interest_pct");
  }

  public String toJson() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(this);
  }
}
