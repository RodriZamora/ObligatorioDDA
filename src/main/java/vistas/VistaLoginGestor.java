
package vistas;

import dominio.Usuario;

public interface VistaLoginGestor {

    public void mostrarMensajeError(String message);
    
    public void ejecutarSiguienteCU(Usuario usuario);
}
