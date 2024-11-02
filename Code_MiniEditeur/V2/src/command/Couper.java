package command;

import originator.EditeurBuffer;

public class Couper extends Command {

    public Couper(EditeurBuffer editor) {
        super(editor);
    }

    @Override
    public void execute() {
        String texte = editor.getSelection();

        if (!texte.isEmpty()) {
        	
            System.out.println("Texte coupé : " + texte);
            editor.getPressePapier().setContenu(texte);  
            editor.effacerSelection(); 
            
        } else {
            System.out.println("Aucune sélection à couper");
        }
    }
}
