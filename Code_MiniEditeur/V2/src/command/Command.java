package command;

import originator.EditeurBuffer;

public abstract class Command {
    protected EditeurBuffer editor;

    public Command(EditeurBuffer editor) {
    	
        this.editor = editor;
        
    }

    public abstract void execute();
}
