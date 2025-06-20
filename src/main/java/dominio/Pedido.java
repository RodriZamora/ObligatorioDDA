package dominio;

import excepciones.ItemException;
import excepciones.PedidoException;
import java.time.LocalDateTime;
import observer.Observable;

public class Pedido extends Observable {

    private ItemMenu itemMenu;
    private String comentario;
    private EstadoPedido estado;
    private Servicio servicio;
    private Gestor gestorAsignado;
    private LocalDateTime fechaConfirmacion;
    private String nombreCliente;

    public Pedido(ItemMenu itemMenu, String comentario) {
        this.itemMenu = itemMenu;
        this.comentario = comentario;
        this.gestorAsignado = null;
        this.estado = new NoConfirmado();
        this.fechaConfirmacion = null;
        this.nombreCliente = "";
    }

    public ItemMenu getItemMenu() {
        return itemMenu;
    }

    public void setItemMenu(ItemMenu itemMenu) {
        this.itemMenu = itemMenu;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        avisar(EventosPedido.ACTUALIZACION_PEDIDO);
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public LocalDateTime getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(LocalDateTime fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public boolean puedeEliminarse() {
        return true;
    }

    public boolean validar() {
        return itemMenu.validar();

    }

    public void validarItemExiste() throws ItemException {
        if (itemMenu == null) {
            throw new ItemException("Debe seleccionar un item");
        }
    }

    public Gestor getGestorAsignado() {
        return gestorAsignado;
    }

    public void setGestorAsignado(Gestor gestorAsignado) {
        this.gestorAsignado = gestorAsignado;
    }

    public String getNombreEstado() {
        return estado.getNombre();
    }

    public void confirmar() throws PedidoException {
        estado.confirmar(this);
    }

    public boolean estaFinalizado() {
        return estado.estaFinalizado();
    }

    public boolean estaConfirmado() {
        return estado.esConfirmado();
    }

    public boolean estaEntregado() {
        return estado.esEntregado();
    }

    public boolean enProceso() {
        return estado.enProceso();
    }

    public void eliminar() throws PedidoException {
        estado.eliminar(this);
    }

}
