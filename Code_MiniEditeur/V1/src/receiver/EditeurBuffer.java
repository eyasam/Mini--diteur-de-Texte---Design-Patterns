package receiver;

import javax.swing.JTextArea;

import main.PressePapier;

public class EditeurBuffer {
    private String texte;
    private int debutSelection;
    private int finSelection;
    private PressePapier pressePapier;
    private JTextArea textArea; 
    

    public EditeurBuffer(JTextArea textArea) {
       this.textArea = textArea;
       texte ="";
       debutSelection= 0;
       finSelection =0;
       pressePapier =new PressePapier();
    }

    
    // Retourne le texte actuellement sélectionné
    public String getSelection() {
        if ( (debutSelection>=finSelection) 
        		|| (debutSelection<0) 
        		|| (finSelection>texte.length())) 
        {
            return ""; 
        }
        return texte.substring(debutSelection, finSelection);
    }

    // Efface le texte actuellement sélectionné
    public void effacerSelection() {
    	if ( (debutSelection >= finSelection) 
        		|| (debutSelection<0) 
        		|| (finSelection>texte.length())) 
        {
            return;
        }
        texte = texte.substring(0,debutSelection)+texte.substring(finSelection);
        finSelection = debutSelection;
    }

    // Definit les positions de début et de fin de la sélection
    public void setSelection(int debut, int fin) {
        if (debut<0) {
        	debut = 0;
        }
        if (fin>texte.length()) {
        	fin = texte.length();
        }
     
        this.debutSelection = debut;
        this.finSelection = fin;
    }

    // M a j la sélection basée sur la zone de texte
    public void updateSelection(JTextArea text) {
        int start=text.getSelectionStart();
        int end =text.getSelectionEnd();
        setSelection(start,end);
        setTexte(text.getText());
    }

    
    // Colle le texte a la position de début de la sélection
    public void coller(String text) {
        if (text.isEmpty()) {
            return;
        }
        texte = texte.substring(0, debutSelection) + text + texte.substring(debutSelection);
    }

    // Retourne l'instance de PressePapier
    public PressePapier getPressePapier() {
        return pressePapier;
    }
    
    public JTextArea getTextArea() {
        return textArea;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getDebutSelection() {
        return debutSelection;
    }

    public int getFinSelection() {
        return finSelection;
    }
}
