package controladores;

import dominio.Beneficio;
import dominio.Categoria;
import dominio.Cliente;
import dominio.Dispositivo;
import dominio.ItemMenu;
import dominio.Pedido;
import dominio.Servicio;
import excepciones.DispositivoException;
import excepciones.ItemException;
import excepciones.PedidoException;
import java.util.ArrayList;
import java.util.Collection;
import servicios.Fachada;

import vistas.VistaCliente;

public class ClienteControlador extends LoginClienteControlador {

    private VistaCliente vista;

    public ClienteControlador(VistaCliente vista, Dispositivo dispositivo) {
        super(vista, dispositivo);
        this.vista = vista;

    }

    public void crearPedido(ItemMenu itemSeleccionado, String comentario) {
        try {
            validarClienteIdentificado("Debe identificarse antes de realizar pedidos");
            Pedido pedido = new Pedido(itemSeleccionado, comentario);
            pedido.agregarObservador(this);
            servicio.agregarPedido(pedido);
            suscribirObservadores();
            vista.limpiarMensajeDeError();
            mostrarPedidosDeServicio();
        } catch (PedidoException | ItemException ex) {
            vista.mostrarMensajeDeError(ex.getMessage());
        }
    }

    private void suscribirObservadores() {
        for (Pedido p : servicio.getPedidos()) {
            p.agregarObservador(this);
        }
    }

    public void mostrarCategorias() {
        Collection<Categoria> categorias = Fachada.getInstancia().getCategorias();
        vista.cargarCategorias(categorias);
    }

    public void cargarItemsDeCategoria(Categoria categoria) {
        ArrayList<ItemMenu> items = Fachada.getInstancia().getItemsDeCategoria(categoria);
        vista.mostrarItemsDeCategoria(items);
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void mostrarPedidosDeServicio() {
        ArrayList<Pedido> pedidos = servicio.getPedidos();
        vista.mostrarPedidosDeServicio(pedidos);
    }

    public void eliminarPedido(int pedidoSeleccionado) {
        try {
            validarClienteIdentificado("Debe identificarse antes de eliminar pedidos");
            validarPedidoSeleccionado(pedidoSeleccionado);
            Pedido pedido = servicio.getPedidos().get(pedidoSeleccionado);
            pedido.eliminar();
            vista.limpiarMensajeDeError();
        } catch (PedidoException ex) {
            vista.mostrarMensajeDeError(ex.getMessage());
        }
    }

    public void confirmarPedidos() {
        try {
            validarClienteIdentificado("Debe identificarse antes de confirmar el servicio");
            servicio.confirmarPedidos();
            vista.limpiarMensajeDeError();
        } catch (PedidoException | ItemException ex) {
            vista.mostrarMensajeDeError(ex.getMessage());
        }
    }

    private void validarClienteIdentificado(String msj) throws PedidoException {
        if (servicio == null || servicio.getCliente() == null) {
            throw new PedidoException(msj);
        }
    }

    private void validarPedidoSeleccionado(int pedido) throws PedidoException {
        if (pedido == -1) {
            throw new PedidoException("Debe seleccionar un pedido");
        }
    }

    public void finalizarServicio() {
        try {
            validarClienteIdentificado("Debe identificarse antes de finalizar el servicio");
            if (validarSinPedidos()) {
                return;
            }
            servicio.validarQueTodosLosPedidosEstenConfirmados();
            notificarPedidosEnProceso();
            mostrarResumenPago();
            vista.solicitarConfirmacionLectura();
        } catch (PedidoException ex) {
            vista.mostrarMensajeDeError(ex.getMessage());
        }
    }

    private void mostrarResumenPago() {
        Beneficio beneficio = servicio.getCliente().calcularBeneficio(servicio);
        double total = servicio.calcularTotal();
        double montoBeneficio = beneficio.getMonto();
        double montoAPagar = total - montoBeneficio;
        vista.mostrarInfoPago(beneficio.getDescripcion(), montoBeneficio, montoAPagar);
    }

    private void notificarPedidosEnProceso() {
        long cantidad = servicio.validarPedidosProcesadosNoEntregados();
        if (cantidad > 0) {
            vista.mostrarMensajeExitoso("Tienes " + cantidad + " pedidos en proceso, recuerda ir a retirarlos!");
        }
    }

    private boolean validarSinPedidos() {
        ArrayList<Pedido> pedidos = servicio.getPedidos();
        if (pedidos.isEmpty()) {
            vista.limpiarVistaDispositivo();
            logoutYLimpieza();
            return true;
        }
        return false;
    }

    public void logoutYLimpieza() {
        try {
            Cliente cliente = servicio.getCliente();
            Fachada.getInstancia().cerrarSesion(cliente);
            Fachada.getInstancia().liberarDispositivo(cliente);
            servicio.setCliente(null);
            vista.limpiarVistaDispositivo();
            desuscribirObservadores();
            this.servicio = null;
            dispositivo.setCliente(null);
        } catch (DispositivoException ex) {
            vista.mostrarMensajeDeError(ex.getMessage());
        }
    }

    private void desuscribirObservadores() {
        servicio.quitarObservador(this);
        for (Pedido p : servicio.getPedidos()) {
            p.quitarObservador(this);
        }
    }

}
