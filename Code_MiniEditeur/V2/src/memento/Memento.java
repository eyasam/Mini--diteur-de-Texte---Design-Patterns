package memento;

public class Memento {
    private final String texte;
    private final int debutSelection;
    private final int finSelection;

    public Memento(String texte, int debutSelection, int finSelection) {
        this.texte = texte;
        this.debutSelection = debutSelection;
        this.finSelection = finSelection;
    }

    public String getTexte() {
        return texte;
    }

    public int getDebutSelection() {
        return debutSelection;
    }

    public int getFinSelection() {
        return finSelection;
    }

}
