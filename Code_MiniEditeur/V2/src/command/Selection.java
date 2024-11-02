package command;

import originator.EditeurBuffer;

public abstract class Selection extends Command {

    public Selection(EditeurBuffer editor) {
        super(editor);
    }

    @Override
    public abstract void execute();
    
}
