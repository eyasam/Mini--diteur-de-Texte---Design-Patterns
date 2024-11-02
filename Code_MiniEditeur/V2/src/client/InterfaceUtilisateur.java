package client;

import javax.swing.*;
import command.Coller;
import command.Copier;
import command.Couper;
import command.DeplacerSelectionDroite;
import command.DeplacerSelectionGauche;
import command.EnregistrerAction;
import command.DefaireAction;
import command.RefaireAction;
import command.RejouerAction;
import invoker.Bouton;
import originator.EditeurBuffer;
import caretaker.Historique;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceUtilisateur {

    private Bouton[] boutons;
    private EditeurBuffer editeur;
    private JTextArea textArea;
    private Historique historique; 
    private EnregistrerAction enregistrerAction; 

    public InterfaceUtilisateur() {
        JFrame frame = new JFrame("Editeur de texte V2");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea(10, 60);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        editeur = new EditeurBuffer(textArea);
        historique = new Historique();
        enregistrerAction = new EnregistrerAction(editeur);
        
        boutons = new Bouton[9]; 
        
        boutons[0] = new Bouton("Copier");
        boutons[1] = new Bouton("Couper");
        boutons[2] = new Bouton("Coller");
        boutons[3] = new Bouton("<-");
        boutons[4] = new Bouton("->");
        boutons[5] = new Bouton("↺ (undo)");
        boutons[6] = new Bouton("↻ (redo)");
        boutons[7] = new Bouton("Enregistrer ⏺");
        boutons[8] = new Bouton("Rejouer (replay)");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        for (Bouton bouton : boutons) {
            buttonPanel.add(bouton);
        }

        boutons[0].setCommand(new Copier(editeur));
        boutons[1].setCommand(new Couper(editeur));
        boutons[2].setCommand(new Coller(editeur));
        boutons[3].setCommand(new DeplacerSelectionGauche(editeur));
        boutons[4].setCommand(new DeplacerSelectionDroite(editeur));
        boutons[5].setCommand(new DefaireAction(editeur, historique));
        boutons[6].setCommand(new RefaireAction(editeur, historique));
        boutons[7].setCommand(enregistrerAction);
        boutons[8].setCommand(new RejouerAction(editeur, enregistrerAction.getScript()));

        panel.add(buttonPanel, BorderLayout.SOUTH);

        for (int i=0; i <boutons.length; i++) {
            final int index = i;
            boutons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    editeur.updateSelection(textArea);
                    boutons[index].executeCommand();
                    if (index < 5) {
                    	historique.saveState(editeur);
                        enregistrerAction.addCommand(boutons[index].getCommand());
                    }
                    textArea.setText(editeur.getTexte());
                    textArea.setSelectionStart(editeur.getDebutSelection());
                    textArea.setSelectionEnd(editeur.getFinSelection());
                }
            });
        }

        frame.add(panel);
        frame.setSize(800,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

