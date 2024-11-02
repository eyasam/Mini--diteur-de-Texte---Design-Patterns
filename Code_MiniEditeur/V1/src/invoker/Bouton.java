package invoker;

import javax.swing.JButton;
import command.Command;

public class Bouton extends JButton {
	
    private Command command;

    public Bouton(String label) {
        super(label); 
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null) {
            command.execute();
        }
    }
}
