// GestionEvenements.java
import java.util.HashMap;
import java.util.Map;

public class GestionEvenements {
    private static GestionEvenements instance;
    private Map<String, Evenement> evenements;

    private GestionEvenements() {
        evenements = new HashMap<>();
    }

    public static GestionEvenements getInstance() {
        if (instance == null) {
            instance = new GestionEvenements();
        }
        return instance;
    }

    public void ajouterEvenement(Evenement evenement) {
        evenements.put(evenement.getTitre(), evenement);
    }

    public void supprimerEvenement(String titre) {
        evenements.remove(titre);
    }

    public Evenement rechercherEvenement(String titre) {
        return evenements.get(titre);
    }

    public Map<String, Evenement> getEvenements() {
        return evenements;
    }
}
