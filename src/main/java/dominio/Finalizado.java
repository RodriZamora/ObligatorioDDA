package dominio;

import excepciones.PedidoException;

public class Finalizado extends EstadoPedidoAbstracto implements EstadoPedido {

    @Override
    public void eliminar(Pedido pedido) throws PedidoException {
        throw new PedidoException("No se puede eliminar el pedido, ya está finalizado");
    }

    @Override
    public void finalizar(Pedido pedido) throws PedidoException {
        throw new PedidoException("El pedido ya está finalizado");
    }

    @Override
    public void entregar(Pedido pedido) {
        pedido.setEstado(new Entregado());
    }

    @Override
    public String getNombre() {
        return "Finalizado";
    }

    @Override
    public boolean estaFinalizado() {
        return true;
    }

    @Override
    public boolean esConfirmado() {
        return true;
    }

}
