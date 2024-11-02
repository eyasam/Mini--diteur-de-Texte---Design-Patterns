package command;

import originator.EditeurBuffer;

public class Copier extends Command {
    
    public Copier(EditeurBuffer editor) {
        super(editor);
    }

    @Override
    public void execute() {
        String texte = editor.getSelection();
        
        if (!texte.isEmpty()) {
        	
            System.out.println("Texte copié : " + texte);
            editor.getPressePapier().setContenu(texte); 
            
        } else {
        	
            System.out.println("Aucune sélection à copier");
        }
    }
}
