package dominio;

import observer.Observable;
import excepciones.ItemException;
import excepciones.PedidoException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Servicio extends Observable {

    private ArrayList<Pedido> pedidos = new ArrayList();

    private Cliente cliente;

    public Servicio() {

    }

    public final void agregarPedido(Pedido pedido) throws PedidoException, ItemException {
        if (cliente == null) {
            throw new PedidoException("Debe identificarse antes de realizar pedidos");
        }
        pedido.validarItemExiste();
        validarAlAgregarPedido(pedido);
        pedido.setServicio(this);
        pedido.setNombreCliente(cliente.getNombreCompleto());
        pedidos.add(pedido);
        avisar(EventosPedido.ALTA_PEDIDO);
    }

    public Servicio(Cliente cliente) {
        this.cliente = cliente;
        this.pedidos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public double calcularTotal() {
        double total = 0;
        for (Pedido p : pedidos) {
            total += p.getItemMenu().getPrecioUnitario();
        }
        return total;
    }

    public void eliminar(Pedido pedido) {
        pedidos.remove(pedido);
        avisar(EventosPedido.BAJA_PEDIDO);
    }

    public void validar() {

    }

    public double obtenerTotalItem(String item) {
        double montoItem = 0;
        for (Pedido p : pedidos) {
            if (p.getItemMenu().getNombre().equals(item)) {
                montoItem += p.getItemMenu().getPrecioUnitario();
            }
        }
        return montoItem;
    }

    public void confirmarPedidos() throws PedidoException, ItemException {
        if (cliente == null) {
            throw new PedidoException("Debe identificarse antes de confirmar el servicio");
        }

        if (pedidos.isEmpty() || noHayPedidosNuevos()) {
            throw new PedidoException("No hay pedidos nuevos");
        }

        for (Pedido p : pedidos) {
            if (!p.estaConfirmado()) {
                validarAlConfirmarPedidos(p);
                p.confirmar();
                p.setFechaConfirmacion(LocalDateTime.now());
                p.getItemMenu().descontarStock();
                avisar(EventosPedido.ACTUALIZACION_PEDIDO);
            }
        }
    }

    private boolean noHayPedidosNuevos() {
        for (Pedido p : pedidos) {
            if (!p.estaConfirmado()) {
                return false;
            }
        }
        return true;
    }

    private void validarAlAgregarPedido(Pedido pedido) throws ItemException {
        if (pedido.validar()) {
            pedidos.remove(pedido);
            avisar(EventosPedido.BAJA_PEDIDO);
            throw new ItemException("Nos hemos quedado sin stock de " + pedido.getItemMenu().getNombre() + " y no pudimos avisarte antes");
        }
    }

    private void validarAlConfirmarPedidos(Pedido pedido) throws ItemException {
        if (pedido.validar()) {
            pedidos.remove(pedido);
            avisar(EventosPedido.BAJA_PEDIDO);
            throw new ItemException("Lo sentimos, nos hemos quedado sin stock de " + pedido.getItemMenu().getNombre() + " por lo que lo hemos quitado el pedido del servicio");
        }
    }

    public void validarQueTodosLosPedidosEstenConfirmados() throws PedidoException {
        for (Pedido p : pedidos) {
            if (p.getEstado() instanceof NoConfirmado) {
                throw new PedidoException("Tienes pedidos sin confirmar!");
            }
        }
    }

    public long validarPedidosProcesadosNoEntregados() {
        long contador = 0;
        for (Pedido p : pedidos) {
            if (p.estaConfirmado() && !p.estaEntregado()) {
                contador++;
            }
        }
        return contador;
    }

}
