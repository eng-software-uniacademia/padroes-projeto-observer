import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UsuarioTest {
    @Test
    void deveNotificarUmUsuario() {
        Grupo grupo = new Grupo("Algoritmos");
        Usuario usuario = new Usuario("usuario 1");
        usuario.enviarMensagem(grupo);
        grupo.atualizarNotificacoes();
        assertEquals("Algoritmos - nova mensagem de usuario 1", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarios() {
        Grupo grupo = new Grupo("Algoritmos");
        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 2");
        usuario1.enviarMensagem(grupo);
        usuario2.enviarMensagem(grupo);
        grupo.atualizarNotificacoes();
        assertEquals("Algoritmos - nova mensagem de Usuario 1", usuario1.getUltimaNotificacao());
        assertEquals("Algoritmos - nova mensagem de Usuario 2", usuario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarUsuario() {
        Grupo grupo = new Grupo("Algoritmos");
        Usuario usuario = new Usuario("Usuario 1");
        grupo.atualizarNotificacoes();
        assertNull(usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarioGrupoA() {
        Grupo grupoA = new Grupo("A");
        Grupo grupoB = new Grupo("B");
        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 2");
        usuario1.enviarMensagem(grupoA);
        usuario2.enviarMensagem(grupoB);
        grupoA.atualizarNotificacoes();
        assertEquals("A - nova mensagem de Usuario 1", usuario1.getUltimaNotificacao());
        assertNull(usuario2.getUltimaNotificacao());
    }
}
