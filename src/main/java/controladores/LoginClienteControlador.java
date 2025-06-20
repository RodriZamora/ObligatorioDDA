package controladores;

import dominio.Cliente;
import dominio.Dispositivo;
import dominio.EventosPedido;
import dominio.Pedido;
import dominio.Servicio;
import dominio.Usuario;
import excepciones.DispositivoException;
import excepciones.LoginException;
import observer.Observable;
import observer.Observador;
import servicios.Fachada;
import vistas.VistaCliente;

public class LoginClienteControlador extends LoginBaseControlador implements Observador {

    protected final VistaCliente vista;
    protected Dispositivo dispositivo;
    protected Servicio servicio;

    public LoginClienteControlador(VistaCliente vista, Dispositivo dispositivo) {
        this.vista = vista;
        this.dispositivo = dispositivo;
        inicializarVista();
    }

    public void procesarLogin(String usuario, String password) {
        try {
            Usuario u = login(usuario, password);
            vista.limpiarMensajeDeError();
            vista.mostrarMensajeBienvenida("Realizar Pedido - " + u.getNombreCompleto());
            this.servicio = new Servicio();
            servicio.agregarObservador(this);
            servicio.setCliente((Cliente) u);
            Fachada.getInstancia().agregarServicio(servicio);
            dispositivo.ocupar();
            dispositivo.setCliente((Cliente) u);
        } catch (LoginException | DispositivoException ex) {
            vista.mostrarMensajeDeError(ex.getMessage());
        }
    }

    private Usuario login(String usuario, String password) throws LoginException, DispositivoException {

        Usuario u = loginGenerico(usuario, password);

        if (!(u instanceof Cliente)) {
            throw new LoginException("Credenciales incorrectas");
        }

        Cliente cliente = Fachada.getInstancia().loginCliente(usuario, password, this.obtenerDispositivoActual());
        Fachada.getInstancia().clienteEstalogeado(cliente, dispositivo);

        return cliente;
    }

    private Dispositivo obtenerDispositivoActual() {
        return dispositivo;
    }

    private void inicializarVista() {
        mostrarInfoDispositivo(dispositivo);
    }

    private void mostrarInfoDispositivo(Dispositivo dispositivo) {
        vista.mostrarMensajeBienvenida("Dispositivo :" + dispositivo.getNumIdentificador());
    }

    @Override
    public void actualizar(Observable origen, Object evento) {

        if (evento.equals(EventosPedido.ALTA_PEDIDO)
                | evento.equals(EventosPedido.BAJA_PEDIDO)
                | evento.equals(EventosPedido.ACTUALIZACION_PEDIDO)) {
            vista.mostrarPedidosDeServicio(servicio.getPedidos());
            vista.cargarMontoTotal(String.format("%.2f", servicio.calcularTotal()));

        }

        if (origen instanceof Pedido) {
            Pedido p = (Pedido) origen;
            if (p.estaFinalizado()) {
                vista.mostrarMensajeExitoso("El pedido está listo para ser retirado: " + p.getItemMenu().getNombre());
            }
        }
    }

}
