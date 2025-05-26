// FormEvent.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormEvent extends JFrame {
    private JTextField tfNom;
    private JTextField tfDate;
    private JTextField tfLieu;
    private JTextField tfCapacite;
    private JComboBox<String> cbType;
    private JButton btnCreer;

    public FormEvent() {
        setTitle("Créer Événement");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tfNom = new JTextField();
        tfDate = new JTextField();
        tfLieu = new JTextField();
        tfCapacite = new JTextField();
        cbType = new JComboBox<>(new String[]{"Concert", "Conférence"});
        btnCreer = new JButton("Créer");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Nom :"));
        panel.add(tfNom);
        panel.add(new JLabel("Date :"));
        panel.add(tfDate);
        panel.add(new JLabel("Lieu :"));
        panel.add(tfLieu);
        panel.add(new JLabel("Capacité Max :"));
        panel.add(tfCapacite);
        panel.add(new JLabel("Type :"));
        panel.add(cbType);
        panel.add(btnCreer);

        add(panel);

        btnCreer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = tfNom.getText();
                String date = tfDate.getText();
                String lieu = tfLieu.getText();
                int capaciteMax = Integer.parseInt(tfCapacite.getText());
                Evenement evenement;

                if (cbType.getSelectedItem().equals("Concert")) {
                    String artiste = JOptionPane.showInputDialog("Artiste :");
                    String genreMusical = JOptionPane.showInputDialog("Genre Musical :");
                    evenement = new Concert(nom, date, lieu, capaciteMax, artiste, genreMusical);
                } else {
                    String theme = JOptionPane.showInputDialog("Thème :");
                    evenement = new Conference(nom, date, lieu, capaciteMax, theme);
                }

                GestionEvenements gestionEvenements = GestionEvenements.getInstance();
                gestionEvenements.ajouterEvenement(evenement);
                JOptionPane.showMessageDialog(null, "Événement créé avec succès !");
                dispose();
            }
        });
    }
}
