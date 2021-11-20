package pl.edu.wit.frontendcomparator.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import pl.edu.wit.frontendcomparator.models.Game;

import java.util.LinkedList;
import java.util.List;
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

    public List<Game> getLargeLoad() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference collectionReference = dbFirestore.collection("movies");
        ApiFuture<QuerySnapshot> future = collectionReference.get();

        QuerySnapshot collection = future.get();
        List<Game> games = new LinkedList<Game>();
        if(!collection.isEmpty()){
            for(QueryDocumentSnapshot query : collection.getDocuments()) {
                games.add(query.toObject(Game.class));
            }
        }
        return games;
    }

    public List<Game> getMediumLoad() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference collectionReference = dbFirestore.collection("movies");
        ApiFuture<QuerySnapshot> future = collectionReference.get();

        QuerySnapshot collection = future.get();
        List<Game> games = new LinkedList<Game>();
        if(!collection.isEmpty()){
            for(int i=0; i < (collection.getDocuments().size()/2); i++) {
                games.add(collection.getDocuments().get(i).toObject(Game.class));
            }
        }
        return games;
    }

    public List<Game> getSmallLoad() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference collectionReference = dbFirestore.collection("movies");
        ApiFuture<QuerySnapshot> future = collectionReference.get();

        QuerySnapshot collection = future.get();
        List<Game> games = new LinkedList<Game>();
        if(!collection.isEmpty()){
            for(int i=0; i < (collection.getDocuments().size()/4); i++) {
                games.add(collection.getDocuments().get(i).toObject(Game.class));
            }
        }
        return games;
    }

    public String deleteGame(Game game) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("movies").document(game.getTitle()).delete();
        return "Document: " + game.getTitle() + "has been deleted";
    }

}
