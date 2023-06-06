import java.util.Observable;

public class Grupo extends Observable {
    private final String nome;

    public Grupo(String nome) {
        this.nome = nome;
    }

    public void atualizarNotificacoes() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
