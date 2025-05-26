// EvenementObservable.java
public interface EvenementObservable {
    void addObserver(ParticipantObserver observer);
    void notifyObservers();
}
