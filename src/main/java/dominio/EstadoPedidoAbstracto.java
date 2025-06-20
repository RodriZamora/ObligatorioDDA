package dominio;

import excepciones.PedidoException;

public abstract class EstadoPedidoAbstracto implements EstadoPedido {

    @Override
    public void cobrar(Pedido pedido) {

    }

    @Override
    public void eliminar(Pedido pedido) throws PedidoException {
        throw new PedidoException("No se puede eliminar un pedido en estado " + getNombre());
    }

    @Override
    public void confirmar(Pedido pedido) {

    }

    @Override
    public void tomar(Pedido pedido) {

    }

    @Override
    public void finalizar(Pedido pedido) throws PedidoException {
        
    }

    @Override
    public void entregar(Pedido pedido) throws PedidoException {

    }
    
    @Override
    public boolean estaFinalizado() {
        return false;
    }
    
    @Override
    public boolean esConfirmado() {
        return false;
    }
    
    @Override
    public boolean esEntregado() {
        return false;
    }
    
    @Override
    public boolean enProceso(){
        return false;
    }
    


}
