package controladores;

import dominio.Gestor;
import dominio.Sesion;
import dominio.Usuario;
import excepciones.LoginException;
import servicios.Fachada;
import vistas.VistaLoginGestor;

public class LoginGestorControlador extends LoginBaseControlador {

    protected VistaLoginGestor vista;

    public LoginGestorControlador(VistaLoginGestor vista) {
        this.vista = vista;
    }

    public void procesarLogin(String usuario, String password) {
        try {
            Usuario u = loginGenerico(usuario, password);
            Fachada.getInstancia().gestorEstaLogueado((Gestor)u);
            Fachada.getInstancia().agregar(new Sesion(u));
            vista.ejecutarSiguienteCU(u);
        } catch (LoginException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
    }

}
