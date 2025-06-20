package dominio;

import excepciones.PedidoException;

public class Entregado extends EstadoPedidoAbstracto {

    @Override
    public void eliminar(Pedido pedido) throws PedidoException {
        throw new PedidoException("El pedido ya fue entregado");
    }
    
    @Override
    public void finalizar(Pedido pedido) throws PedidoException {
        throw new PedidoException("El pedido ya está entregado");
    }
    
    @Override
    public void entregar(Pedido pedido) throws PedidoException {
        throw new PedidoException("El pedido ya está entregado");
    }
    
    @Override
    public String getNombre() {
        return "Entregado";
    }
    
    @Override
    public boolean esConfirmado() {
        return true;
    }
    
    @Override
    public boolean esEntregado() {
        return true;
    }

}
