/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dominio.EventosPedido;
import dominio.Gestor;
import dominio.Pedido;
import dominio.UnidadProcesadora;
import excepciones.PedidoException;
import java.util.ArrayList;
import java.util.List;
import observer.Observable;
import observer.Observador;
import servicios.Fachada;
import vistas.PantallaGestor;

/**
 *
 * @author ASUS
 */
public class GestorControlador implements Observador {

    private final PantallaGestor vista;
    private final Gestor gestor;

    public GestorControlador(PantallaGestor vista, Gestor gestor) {
        this.vista = vista;
        this.gestor = gestor;
        Fachada.getInstancia().agregarObservador(this);
    }

    public void inicializarVista() {
        vista.mostrarDatosGestor(gestor);
        cargarYMostrarPedidos();
    }

    private void cargarYMostrarPedidos() {
        UnidadProcesadora up = gestor.getUnidadProcesadora();
        List<Pedido> pendientes = Fachada.getInstancia().obtenerPedidosPendientes(up);
        suscribirObservadores(pendientes);
        vista.mostrarPedidosPendientesYSinGestorAsignado(pendientes);
    }

    private void suscribirObservadores(List<Pedido> pendientes) {
        for (Pedido p : pendientes) {
            p.agregarObservador(this);
        }
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (evento.equals(EventosPedido.ACTUALIZACION_PEDIDO) || evento.equals(EventosPedido.BAJA_PEDIDO)) {
            cargarYMostrarPedidos();
            mostrarPedidosTomadosPorGestor();
        }
    }

    public void tomarPedido(Pedido pedido) {
        try {
            validarPedidoSeleccionado(pedido);
            pedido.agregarObservador(this);
            Fachada.getInstancia().asignarGestorAPedido(gestor, pedido);
            pedido.getEstado().tomar(pedido);
            mostrarPedidosTomadosPorGestor();
            vista.limpiarMensajeError();
        } catch (PedidoException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
    }

    private void mostrarPedidosTomadosPorGestor() {
        ArrayList<Pedido> tomados = Fachada.getInstancia().pedidosTomadosGestor(gestor);
        vista.mostrarPedidosTomados(tomados);
    }

    private void validarPedidoSeleccionado(Pedido pedido) throws PedidoException {
        if (pedido == null) {
            throw new PedidoException("Debe seleccionar un pedido");
        }
    }

    public void finalizarPedido(int pedidoSeleccionado) {
        try {
            Pedido p = validarYObtenerPedido(pedidoSeleccionado);
            p.getEstado().finalizar(p);
            vista.limpiarMensajeError();
        } catch (PedidoException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
    }

    private Pedido validarYObtenerPedido(int pedidoSeleccionado) throws PedidoException {
        validarQueSeSeleccionoUnPedido(pedidoSeleccionado);
        List<Pedido> tomados = Fachada.getInstancia().pedidosTomadosGestor(gestor);
        Pedido p = tomados.get(pedidoSeleccionado);
        validarPedidoSeleccionado(p);
        p.agregarObservador(this);
        return p;
    }

    private void validarQueSeSeleccionoUnPedido(int pedidoSeleccionado) throws PedidoException {
        if (pedidoSeleccionado == -1) {
            throw new PedidoException("Debe seleccionar un pedido");
        }
    }

    public void entregarPedido(int pedidoSeleccionado) {
        try {
            Pedido p = validarYObtenerPedido(pedidoSeleccionado);
            p.getEstado().entregar(p);
            vista.limpiarMensajeError();
        } catch (PedidoException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
    }

    public void logout() {
        try {
            List<Pedido> tomados = Fachada.getInstancia().pedidosTomadosGestor(gestor);
            tieneNoEntregados(tomados);
            desuscribirObservadores(tomados);
            Fachada.getInstancia().logoutGestor(gestor);
            vista.cerrarVista();
        } catch (PedidoException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }

    }

    private void desuscribirObservadores(List<Pedido> tomados) {
        Fachada.getInstancia().quitarObservador(this);
        for (Pedido p : tomados) {
            p.quitarObservador(this);
        }
    }

    private void tieneNoEntregados(List<Pedido> tomados) throws PedidoException {
        for (Pedido p : tomados) {
            if (!p.estaEntregado()) {
                throw new PedidoException("Tiene pedidos pendientes");
            }
        }
    }

}
