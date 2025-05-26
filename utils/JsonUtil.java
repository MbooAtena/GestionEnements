// JsonUtil.java
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    private Gson gson;

    public JsonUtil() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void sauvegarderParticipant(Participant participant) {
        try (FileWriter writer = new FileWriter("participants.json", true)) {
            String json = gson.toJson(participant);
            writer.write(json + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sauvegarderEvenement(Evenement evenement) {
        try (FileWriter writer = new FileWriter("evenements.json", true)) {
            String json = gson.toJson(evenement);
            writer.write(json + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Evenement> chargerEvenements() {
        List<Evenement> evenements = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("evenements.json"));
            for (String line : lines) {
                Evenement evenement = gson.fromJson(line, Evenement.class);
                evenements.add(evenement);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return evenements;
    }
}
