
package controladores;

import dominio.Usuario;
import excepciones.LoginException;
import servicios.Fachada;

public class LoginBaseControlador {
    
    
    protected final Fachada fachada;
    
    public LoginBaseControlador(){
        this.fachada = Fachada.getInstancia();
    }
    
    protected Usuario loginGenerico(String usuario, String password) throws LoginException{
        Usuario u = fachada.obtenerUsuario(usuario, password);
        if ( u == null){
            throw new LoginException("Credenciales incorrectas");
        } 
        return u;
    }
    
}
