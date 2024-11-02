package originator;

import javax.swing.JTextArea;

import main.PressePapier;
import memento.Memento;

public class EditeurBuffer {
    private String texte;
    private int debutSelection;
    private int finSelection;
    private PressePapier pressePapier;
    private JTextArea textArea;

    public EditeurBuffer(JTextArea textArea) {
        this.textArea = textArea;
        texte = "";
        debutSelection = 0;
        finSelection = 0;
        pressePapier = new PressePapier();
    }

    // Crée un memento représentant l'état actuel de l'éditeur
    public Memento createMemento() {
        return new Memento(texte, debutSelection, finSelection);
    }

    // Restaure l'état de l'éditeur à partir d'un memento
    public void restoreMemento(Memento memento) {
        this.texte = memento.getTexte();
        this.debutSelection = memento.getDebutSelection();
        this.finSelection = memento.getFinSelection();
        textArea.setText(texte);
        textArea.setSelectionStart(debutSelection);
        textArea.setSelectionEnd(finSelection);
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

    public void coller(String text) {
        if (text.isEmpty()) {
            return;
        }
        texte = texte.substring(0, debutSelection) + text + texte.substring(debutSelection);
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

    public PressePapier getPressePapier() {
        return pressePapier;
    }
}
