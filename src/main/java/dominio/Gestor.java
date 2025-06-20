package dominio;

import dominio.Usuario;
import excepciones.LoginException;
import java.util.ArrayList;
import java.util.Objects;

public class Gestor extends Usuario {

    private String nombreUsuario;

    private UnidadProcesadora unidadProcesadora;

    

    public Gestor(String nombreUsuario, String nombreCompleto, String password, UnidadProcesadora unidadProcesadora) {
        super(nombreCompleto, password);
        this.nombreUsuario = nombreUsuario;
        this.unidadProcesadora = unidadProcesadora;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nombreUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gestor other = (Gestor) obj;
        return Objects.equals(this.nombreUsuario, other.nombreUsuario);
    }

    @Override
    public void validarUsuario(String usuario, String password) throws LoginException {
        if (!getPassword().equals(password) || !getNombreUsuario().equals(usuario)) {
            throw new LoginException("Credenciales incorrectas");
        }
    }


}
