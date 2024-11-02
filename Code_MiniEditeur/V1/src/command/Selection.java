package command;

import receiver.EditeurBuffer;

public abstract class Selection extends Command {

    public Selection(EditeurBuffer editor) {
        super(editor);
    }

    @Override
    public abstract void execute();
}
