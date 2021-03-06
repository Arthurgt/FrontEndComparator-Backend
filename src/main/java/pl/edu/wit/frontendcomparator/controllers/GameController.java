package pl.edu.wit.frontendcomparator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wit.frontendcomparator.models.Game;
import pl.edu.wit.frontendcomparator.services.FirebaseService;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class GameController {

    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/getLargeLoad")
    public List<Game> getLargeLoad() throws ExecutionException, InterruptedException {
        return firebaseService.getLargeLoad();
    }

    @GetMapping("/getMediumLoad")
    public List<Game> getMediumLoad() throws ExecutionException, InterruptedException {
        return firebaseService.getMediumLoad();
    }

    @GetMapping("/getSmallLoad")
    public List<Game> getSmallLoad() throws ExecutionException, InterruptedException {
        return firebaseService.getSmallLoad();
    }

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

    @DeleteMapping("/deleteGame/{title}")
    public String deleteGame(@PathVariable String title) throws ExecutionException, InterruptedException {
        return firebaseService.deleteGame(title);
    }

}
