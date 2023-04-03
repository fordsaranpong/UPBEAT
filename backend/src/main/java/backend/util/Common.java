package backend.util;

import java.util.Random;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class Common {
  public static int getRandomNumberInRange(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
  }

  public static Map<String, String> parseUrlEncoded(String formData) throws UnsupportedEncodingException {
    Map<String, String> map = new HashMap<String, String>();

    if (formData != null) {
      String[] pairs = formData.split("&");
      for (String pair : pairs) {
        int index = pair.indexOf("=");
        String key = index > 0 ? URLDecoder.decode(pair.substring(0, index), "UTF-8") : pair;
        String value = index > 0 && pair.length() > index + 1 ? URLDecoder.decode(pair.substring(index + 1), "UTF-8")
            : null;
        map.put(key, value);
      }
    }

    return map;
  }
}
