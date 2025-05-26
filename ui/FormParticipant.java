// FormParticipant.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormParticipant extends JFrame {
    private JTextField tfNom;
    private JTextField tfEmail;
    private JCheckBox cbOrganisateur;
    private JButton btnCreer;

    public FormParticipant() {
        setTitle("Inscription Participant");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tfNom = new JTextField();
        tfEmail = new JTextField();
        cbOrganisateur = new JCheckBox("Organisateur");
        btnCreer = new JButton("Créer");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Nom :"));
        panel.add(tfNom);
        panel.add(new JLabel("Email :"));
        panel.add(tfEmail);
        panel.add(cbOrganisateur);
        panel.add(btnCreer);

        add(panel);

        btnCreer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = tfNom.getText();
                String email = tfEmail.getText();
                Participant participant = new Participant(nom, email);
                JsonUtil jsonUtil = new JsonUtil();
                jsonUtil.sauvegarderParticipant(participant);

                if (cbOrganisateur.isSelected()) {
                    new AccueilOrganisateur().setVisible(true);
                } else {
                    new AccueilParticipant().setVisible(true);
                }
                dispose();
            }
        });
    }
}
