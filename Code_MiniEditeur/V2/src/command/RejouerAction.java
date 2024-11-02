package command;

import java.util.List;

import originator.EditeurBuffer;

public class RejouerAction extends Command {
    private List<Command> script;

    public RejouerAction(EditeurBuffer editor, List<Command> script) {
        super(editor);
        this.script = script;
    }

    @Override
    public void execute() {
        System.out.println("Rejouement des actions");
        for (Command command: script) {
            command.execute();       
        }
    }
}
