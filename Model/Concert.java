// Concert.java
public class Concert extends Evenement {
    private String artiste;
    private String genreMusical;

    public Concert(String titre, String date, String lieu, int capaciteMax, String artiste, String genreMusical) {
        super(titre, date, lieu, capaciteMax);
        this.artiste = artiste;
        this.genreMusical = genreMusical;
    }

    // Getters et Setters
}
