package command;

import caretaker.Historique;
import originator.EditeurBuffer;

public class RefaireAction extends Command {
    private Historique historique;

    public RefaireAction(EditeurBuffer editor, Historique historique) {
        super(editor);
        this.historique = historique;
    }

    @Override
    public void execute() {
    	historique.redo(editor);
    }
}
