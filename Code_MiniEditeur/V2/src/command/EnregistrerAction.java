package command;

import java.util.ArrayList;
import java.util.List;

import originator.EditeurBuffer;

public class EnregistrerAction extends Command {
    private List<Command> script;

    public EnregistrerAction(EditeurBuffer editor) {
        super(editor);
        this.script = new ArrayList<>();
    }

    public void addCommand(Command command) {
        script.add(command);
    }

    public List<Command> getScript() {
        return script;
    }

    @Override
    public void execute() {
        script.clear(); 
        System.out.println("Enregistrement des actions démarré");
    }
}
