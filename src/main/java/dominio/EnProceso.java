package dominio;

import excepciones.PedidoException;

public class EnProceso extends EstadoPedidoAbstracto implements EstadoPedido {

    @Override
    public void finalizar(Pedido pedido) {
        pedido.setEstado(new Finalizado());
    }

    @Override
    public void eliminar(Pedido pedido) throws PedidoException {
        throw new PedidoException("Un poco tarde... Ya estamos elaborando este pedido!");
    }
    
    @Override
    public void entregar(Pedido pedido) throws PedidoException {
        throw new PedidoException("Debe finalizar el pedido");
    }

    @Override
    public String getNombre() {
        return "En Proceso";
    }
    
    @Override
    public boolean esConfirmado() {
        return true;
    }
    
    @Override
    public boolean enProceso() {
        return true;
    }

}
