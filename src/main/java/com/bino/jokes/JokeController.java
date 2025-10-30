package com.bino.jokes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@RestController
public class JokeController {

    @GetMapping("/joke")
    public Map<String, Object> getJoke() {
        String apiUrl = "https://official-joke-api.appspot.com/random_joke";
        RestTemplate restTemplate = new RestTemplate();
        Map<String,Object> res = restTemplate.getForObject(apiUrl, Map.class);
        String joke = res.get("setup") + " ... " + res.get("punchline");
        return Map.of("joke", joke);
    }

    @GetMapping("/")
    public String home() {
        return "Bino Joke API in Java is running ✅";
    }
}
