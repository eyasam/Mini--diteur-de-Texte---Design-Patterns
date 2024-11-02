package command;

import caretaker.Historique;
import originator.EditeurBuffer;

public class DefaireAction extends Command {
    private Historique historique;

    public DefaireAction(EditeurBuffer editor, Historique historique) {
    	
        super(editor);
        this.historique = historique;
        
    }

  
	@Override
	public void execute() {
		historique.undo(editor);
	}
}
