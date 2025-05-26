// ParticipantObserver.java
public class ParticipantObserver implements Observer {
    private String nom;

    public ParticipantObserver(String nom) {
        this.nom = nom;
    }

    @Override
    public void update(Evenement evenement) {
        System.out.println(nom + " a été notifié que l'événement " + evenement.getTitre() + " a été modifié ou annulé.");
    }
}
