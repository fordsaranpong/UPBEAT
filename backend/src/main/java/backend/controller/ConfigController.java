package backend.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.App;

@RestController
public class ConfigController {
    @RequestMapping("/config")
    public String index() throws IOException {
      return App.config.toJson();
    }
}
