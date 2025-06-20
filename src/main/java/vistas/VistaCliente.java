package vistas;

import dominio.Categoria;
import dominio.ItemMenu;
import dominio.Pedido;
import java.util.ArrayList;
import java.util.Collection;


public interface VistaCliente {

    void limpiarMensajeDeError();

    void mostrarMensajeDeError(String mensaje);
    
    void mostrarMensajePago(String mensaje);

    void mostrarMensajeBienvenida(String nombreCompleto);

    void cargarCategorias(Collection<Categoria> categorias);
    
    void mostrarItemsDeCategoria(Collection<ItemMenu> items);
    
    void mostrarPedidosDeServicio(ArrayList<Pedido> pedidos);
    
    void mostrarInfoPago(String string, double montoBeneficio, double montoAPagar);
    
    void solicitarConfirmacionLectura();
    
    void limpiarVistaDispositivo();
    
    void mostrarMensajeExitoso(String mensaje);

    public void cargarMontoTotal(String format);
}
