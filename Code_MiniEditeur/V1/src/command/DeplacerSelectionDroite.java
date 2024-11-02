package command;

import receiver.EditeurBuffer;

public class DeplacerSelectionDroite extends Selection {

    public DeplacerSelectionDroite(EditeurBuffer editor) {
        super(editor);
    }

    @Override
    public void execute() {
        int debut =editor.getDebutSelection();
        int fin= editor.getFinSelection();
        String texte= editor.getTexte();

        if (debut>fin) {
            int temp=debut;
            debut=fin;
            fin=temp;
        }

        if (fin<texte.length()) {
            editor.setSelection(debut, fin+1);
        }

        if (editor.getDebutSelection()> editor.getFinSelection()) {
            editor.setSelection(editor.getDebutSelection(), editor.getDebutSelection());
        }

        System.out.println("Selection deplacee à droite. début : " + editor.getDebutSelection() + ", fin : " + editor.getFinSelection());
    }


}
