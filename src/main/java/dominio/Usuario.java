package dominio;

import excepciones.LoginException;

public abstract class Usuario {

    private String nombreCompleto;
    private String password;


    public Usuario(String nombreCompleto, String password) {
        this.nombreCompleto = nombreCompleto;
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public abstract void validarUsuario(String usuario, String password) throws LoginException;

}
