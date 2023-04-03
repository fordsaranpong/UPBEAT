package backend.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.App;
import backend.model.state.GameState;
import backend.util.Common;

@RestController
public class InitController {
  @PostMapping("/init")
  public String executeCommand(@RequestBody String body) throws Exception {
    Map<String, String> form = Common.parseUrlEncoded(body);

    String playerNamesEntry = form.get("players");
    String[] playerNames = playerNamesEntry.split(",");
    
    App.gameState = new GameState(playerNames, App.config);

    return String.format("{\"detail\":%s}", App.gameState == null ? "null" : App.gameState.toJson());
  }
}
