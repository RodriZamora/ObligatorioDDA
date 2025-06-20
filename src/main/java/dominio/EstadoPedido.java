package dominio;

import excepciones.PedidoException;

public interface EstadoPedido {

    public abstract void confirmar(Pedido pedido) throws PedidoException;

    public abstract void eliminar(Pedido pedido) throws PedidoException;

    public abstract void cobrar(Pedido pedido) throws PedidoException;

    public abstract void tomar(Pedido pedido) throws PedidoException;

    public abstract void finalizar(Pedido pedido) throws PedidoException;

    public abstract void entregar(Pedido pedido) throws PedidoException;

    String getNombre();

    public boolean estaFinalizado();

    public boolean esConfirmado();

    public boolean esEntregado();

    public boolean enProceso();

}
