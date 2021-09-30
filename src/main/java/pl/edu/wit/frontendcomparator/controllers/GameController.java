package pl.edu.wit.frontendcomparator.controllers;

import org.springframework.web.bind.annotation.*;
import pl.edu.wit.frontendcomparator.models.Game;

@RestController
public class GameController {

    @GetMapping("/getGame")
    public String getGame(@RequestHeader String title) {
        return "Hello From Get " + title;
    }

    @PostMapping("/createGame")
    public Game createGame(@RequestBody Game game) {
        return game;
    }

    @PutMapping("/updateGame")
    public String updateGame(@RequestBody Game game) {
        return "Hello From put";
    }

    @DeleteMapping("/deleteGame")
    public String deleteGame(@RequestBody Game game) {
        return "Hello From delete";
    }

}
