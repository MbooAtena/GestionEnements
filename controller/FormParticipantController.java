// FormParticipantController.java
import java.util.List;

public class FormParticipantController {
    public void enregistrerParticipant(Participant participant) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.sauvegarderParticipant(participant);
    }

    public List<Evenement> chargerEvenements() {
        JsonUtil jsonUtil = new JsonUtil();
        return jsonUtil.chargerEvenements();
    }
}
