package servicios;

import java.util.Collection;
import dominio.Cliente;
import dominio.Dispositivo;
import dominio.Gestor;
import dominio.Sesion;
import dominio.Usuario;
import excepciones.DispositivoException;
import excepciones.LoginException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import observer.Observable;

public class ServicioUsuario extends Observable {

    private HashMap<String, Usuario> usuarios = new HashMap();
    private ArrayList<Sesion> sesiones = new ArrayList<>();

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }

    public Cliente loginCliente(String usuario, String password, Dispositivo dispositivo) throws LoginException, DispositivoException {

        Usuario u = loginGenerico(usuario, password); // esto lanza si credenciales incorrectas

        Cliente cliente = (Cliente) u;

        if (dispositivoActualTieneCliente(dispositivo)) {
            throw new LoginException("Debe primero finalizar el servicio actual");
        }

        Sesion s = new Sesion(u);
        sesiones.add(s);

        return cliente;
    }

    public void agregar(Usuario usuario) {
        if (usuario != null) {
            if (usuario instanceof Cliente cliente) {
                usuarios.put(cliente.getNumeroCliente(), cliente);
            } else if (usuario instanceof Gestor gestor) {
                usuarios.put(gestor.getNombreUsuario(), gestor);
            }
        }
    }

    public void agregar(Sesion sesion) {
        sesiones.add(sesion);
    }

    private Usuario loginGenerico(String usuario, String password) throws LoginException {
        Usuario u = null;

        if (existe(usuario)) {
            u = getUsuario(usuario);
            u.validarUsuario(usuario, password);
        } else {
            throw new LoginException("El usuario ingresado no existe");
        }

        return u;
    }

    private boolean existe(String usuario) {
        return usuarios.containsKey(usuario);
    }

    private Usuario getUsuario(String usuario) {
        return usuarios.get(usuario);
    }

    public void cerrarSesion(Cliente cliente) {
        Iterator<Sesion> it = sesiones.iterator();
        while (it.hasNext()) {
            Sesion s = it.next();
            if (cliente.equals(s.getCliente())) {
                it.remove();
            }
        }
    }

    public boolean gestorEstaLogueado(Gestor gestor) throws LoginException {
        for (Sesion s : sesiones) {
            if (gestor.equals(s.getGestor())) {
                throw new LoginException("Acceso denegado. El usuario ya está logueado");
            }
        }
        return false;
    }

    private boolean dispositivoActualTieneCliente(Dispositivo dispositivo) {
        return dispositivo.getEstado() == Dispositivo.Estados.Ocupado;
    }

    public Usuario obtenerUsuario(String usuario, String password) throws LoginException {
        Usuario u = null;
        if (existe(usuario)) {
            u = getUsuario(usuario);
            u.validarUsuario(usuario, password);
        }

        return u;
    }

    public void logoutGestor(Gestor gestor) {
        Iterator<Sesion> it = sesiones.iterator();
        while (it.hasNext()) {
            Sesion s = it.next();
            if (gestor.equals(s.getGestor())) {
                it.remove();
            }
        }
    }

}
