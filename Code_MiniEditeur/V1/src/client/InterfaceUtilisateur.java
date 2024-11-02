package client;

import javax.swing.*;

import command.Coller;
import command.Copier;
import command.Couper;
import command.DeplacerSelectionDroite;
import command.DeplacerSelectionGauche;
import invoker.Bouton;
import receiver.EditeurBuffer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceUtilisateur {
	
	private Bouton[] boutons;
    private EditeurBuffer editeur;
    private JTextArea textArea;

    public InterfaceUtilisateur() {

        JFrame frame = new JFrame("Editeur de texte V1");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        textArea = new JTextArea(10, 40); 
        JScrollPane scrollPane = new JScrollPane(textArea); 
        panel.add(scrollPane, BorderLayout.CENTER); 

        editeur = new EditeurBuffer(textArea); 
        
        boutons = new Bouton[5];
        boutons[0] = new Bouton("Copier");
        boutons[1] = new Bouton("Couper");
        boutons[2] = new Bouton("Coller");
        boutons[3] = new Bouton("<-"); 
        boutons[4] = new Bouton("->");  

        JPanel buttonPanel =new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        for (Bouton bouton :boutons) {
            buttonPanel.add(bouton);
        }

        boutons[0].setCommand(new Copier(editeur));  
        boutons[1].setCommand(new Couper(editeur));  
        boutons[2].setCommand(new Coller(editeur)); 
        boutons[3].setCommand(new DeplacerSelectionGauche(editeur));  
        boutons[4].setCommand(new DeplacerSelectionDroite(editeur)); 
        panel.add(buttonPanel,BorderLayout.SOUTH);

       
        boutons[0].addActionListener(new ActionListener() {  // Action pour Copier
            @Override
            public void actionPerformed(ActionEvent e) {
                editeur.updateSelection(textArea);
                boutons[0].executeCommand();
            }
        });

        for (int i=1; i<boutons.length;i++) {
            final int index = i;  
            boutons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    editeur.updateSelection(textArea);
                    boutons[index].executeCommand();
                    
                    // Mise à jour de la zone de texte pour afficher les changements
                    textArea.setText(editeur.getTexte());
                    textArea.setSelectionStart(editeur.getDebutSelection());
                    textArea.setSelectionEnd(editeur.getFinSelection());
                }
            });
        }

        frame.add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


 
}