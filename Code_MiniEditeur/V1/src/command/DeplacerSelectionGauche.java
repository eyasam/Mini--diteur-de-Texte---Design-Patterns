package command;

import receiver.EditeurBuffer;

public class DeplacerSelectionGauche extends Selection {

    public DeplacerSelectionGauche(EditeurBuffer editor) {
        super(editor);
    }

    @Override
    public void execute() {
        int debut = editor.getDebutSelection();
        int fin = editor.getFinSelection();

        if (debut>fin) {
            int temp=debut;
            debut=fin;
            fin=temp;
        }

        if (debut>0) {
            editor.setSelection(debut-1,fin);
        }

        if (editor.getDebutSelection()> editor.getFinSelection()) {
            editor.setSelection(editor.getDebutSelection(),editor.getDebutSelection());
        }

        System.out.println("Selection déplacee à gauche. début : " + editor.getDebutSelection() + ", fin : " + editor.getFinSelection());
    }


}
