package pl.edu.wit.frontendcomparator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wit.frontendcomparator.models.Game;
import pl.edu.wit.frontendcomparator.services.FirebaseService;
import java.util.concurrent.ExecutionException;

@RestController
public class GameController {

    @Autowired
    FirebaseService firebaseService;

    @CrossOrigin
    @GetMapping("/getGame")
    public Game getGame(@RequestHeader String title) throws ExecutionException, InterruptedException {
        return firebaseService.getGame(title);
    }

    @PostMapping("/createGame")
    public String createGame(@RequestBody Game game) throws ExecutionException, InterruptedException {
        return firebaseService.saveOrUpdateGame(game);
    }

    @PutMapping("/updateGame")
    public String updateGame(@RequestBody Game game) throws ExecutionException, InterruptedException {
        return firebaseService.saveOrUpdateGame(game);
    }

    @DeleteMapping("/deleteGame")
    public String deleteGame(@RequestBody Game game) throws ExecutionException, InterruptedException {
        return firebaseService.deleteGame(game);
    }

}
