package caretaker;

import java.util.Stack;

import memento.Memento;
import originator.EditeurBuffer;

public class Historique {
	
	private Stack<Memento> undoStack; // Pile pour stocker les états - undo
    private Stack<Memento> redoStack; // Pile pour stocker les états - redo

    
    public Historique() {
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }
    
    // Sauvegarde l'état actuel de l'éditeur dans la pile undoStack
    public void saveState(EditeurBuffer editor) {
        undoStack.push(editor.createMemento());
        redoStack.clear();
    }

    public void undo(EditeurBuffer editor) {
        if (!undoStack.isEmpty()) {
            redoStack.push(editor.createMemento());
            editor.restoreMemento(undoStack.pop());
        }
    }

    public void redo(EditeurBuffer editor) {
        if (!redoStack.isEmpty()) {
            undoStack.push(editor.createMemento());
            editor.restoreMemento(redoStack.pop());
        }
    }


    
 }
