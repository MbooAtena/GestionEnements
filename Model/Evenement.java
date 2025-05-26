// Evenement.java
import java.util.ArrayList;
import java.util.List;

public abstract class Evenement implements EvenementObservable {
    private String titre;
    private String date;
    private String lieu;
    private int capaciteMax;
    private List<Participant> participants;
    private List<ParticipantObserver> observers;

    public Evenement(String titre, String date, String lieu, int capaciteMax) {
        this.titre = titre;
        this.date = date;
        this.lieu = lieu;
        this.capaciteMax = capaciteMax;
        this.participants = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void ajouterParticipant(Participant participant) throws CapaciteMaxAtteinteException {
        if (participants.size() >= capaciteMax) {
            throw new CapaciteMaxAtteinteException("Capacité maximale atteinte pour l'événement : " + titre);
        }
        participants.add(participant);
        notifyObservers();
    }

    public void annuler() {
        // Logique pour annuler l'événement
        notifyObservers();
    }

    @Override
    public void addObserver(ParticipantObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (ParticipantObserver observer : observers) {
            observer.update(this);
        }
    }

    // Getters
    public String getTitre() {
        return titre;
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
