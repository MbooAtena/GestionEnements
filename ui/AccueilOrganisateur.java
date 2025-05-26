// AccueilOrganisateur.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccueilOrganisateur extends JFrame {
    public AccueilOrganisateur() {
        setTitle("Accueil Organisateur");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnCreerEvenement = new JButton("Créer Événement");
        btnCreerEvenement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormEvent().setVisible(true);
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(btnCreerEvenement);
        add(panel);
    }
}
