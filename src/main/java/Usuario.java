import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void enviarMensagem(Grupo grupo) {
        grupo.addObserver(this);
    }

    @Override
    public void update(Observable grupo, Object arg) {
        ultimaNotificacao = grupo.toString() + " - nova mensagem de " + this.nome;
    }
}
