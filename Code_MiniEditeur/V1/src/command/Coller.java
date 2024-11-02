package command;

import receiver.EditeurBuffer;

public class Coller extends Command {

    public Coller(EditeurBuffer editor) {
        super(editor);
    }

    @Override
    public void execute() {
        String contenu = editor.getPressePapier().getContenu();

        if (!contenu.isEmpty()) {
            System.out.println("Texte collé : " + contenu);
            editor.coller(contenu);
        } else {
            System.out.println("Presse-papier vide, rien à coller.");
        }
    }
}
