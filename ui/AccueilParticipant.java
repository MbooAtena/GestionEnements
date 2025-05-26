// AccueilParticipant.java
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AccueilParticipant extends JFrame {
    public AccueilParticipant() {
        setTitle("Accueil Participant");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        try {
            List<String> events = Files.readAllLines(Paths.get("evenements.json"));
            for (String event : events) {
                panel.add(new JLabel(event));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(panel);
    }
}
