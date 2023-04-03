package backend.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.App;

@RestController
public class StatusController {
    @RequestMapping("/status")
    public String index() throws IOException {
      return String.format("{\"detail\":%s}", App.gameState == null ? "null" : App.gameState.toJson());
    }
}
