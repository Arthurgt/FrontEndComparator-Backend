package pl.edu.wit.frontendcomparator.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import pl.edu.wit.frontendcomparator.models.Game;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {

    public String saveOrUpdateGame(Game game) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("movies").document(game.getTitle()).set(game);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public Game getGame(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("movies").document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();
        Game game = null;
        if(document.exists()) {
            game = document.toObject(Game.class);
        }
        return game;
    }

    public String deleteGame(Game game) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("movies").document(game.getTitle()).delete();
        return "Document: " + game.getTitle() + "has been deleted";
    }

}
