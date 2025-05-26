// Conference.java
import java.util.ArrayList;
import java.util.List;

public class Conference extends Evenement {
    private String theme;
    private List<Participant> intervenants;

    public Conference(String titre, String date, String lieu, int capaciteMax, String theme) {
        super(titre, date, lieu, capaciteMax);
        this.theme = theme;
        this.intervenants = new ArrayList<>();
    }

    // Getters et Setters
}
