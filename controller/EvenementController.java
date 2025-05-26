// EvenementController.java
import java.util.ArrayList;
import java.util.List;

public class EvenementController {
    private static EvenementController instance;
    private List<Evenement> evenements;

    private EvenementController() {
        evenements = new ArrayList<>();
    }

    public static EvenementController getInstance() {
        if (instance == null) {
            instance = new EvenementController();
        }
        return instance;
    }

    public void ajouterEvenement(Evenement evenement) throws EvenementDejaExistantException {
        for (Evenement e : evenements) {
            if (e.getTitre().equals(evenement.getTitre())) {
                throw new EvenementDejaExistantException("L'événement " + evenement.getTitre() + " existe déjà.");
            }
        }
        evenements.add(evenement);
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }
}
