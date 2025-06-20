package dominio;

public class Sesion {

    private Usuario usuario;

    public Sesion(Usuario usuario) {
        this.usuario = usuario;

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean esCliente() {
        return usuario instanceof Cliente;
    }

    public boolean esGestor() {
        return usuario instanceof Gestor;
    }

    public Cliente getCliente() {
        if (esCliente()) {
            return (Cliente) usuario;
        }
        return null;
    }

    public Gestor getGestor() {
        if (esGestor()) {
            return (Gestor) usuario;
        }
        return null;
    }

}
