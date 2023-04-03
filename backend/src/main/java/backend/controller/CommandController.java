package backend.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.util.Common;

@RestController
public class CommandController {
  @PostMapping("/command")
  public String executeCommand(@RequestBody String body) throws UnsupportedEncodingException {
    Map<String, String> form = Common.parseUrlEncoded(body);

    // Return a response
    return "Command executed: " + form.toString();
  }
}
