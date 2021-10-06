package pl.edu.wit.frontendcomparator.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInitialize {

    @PostConstruct
    public void initialize() {
        try {
            String path = new java.io.File(".").getCanonicalPath();
            path = path + "/src/main/resources/serviceAccount.json";
            FileInputStream serviceAccount =
                    new FileInputStream(path);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://gamesdatabasestudent.europe-central2.firebasedatabase.app")
                    .build();

            FirebaseApp.initializeApp(options);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
