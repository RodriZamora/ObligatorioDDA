package dominio;

public class NoConfirmado extends EstadoPedidoAbstracto implements EstadoPedido {

    @Override
    public void confirmar(Pedido pedido) {
        pedido.setEstado(new Confirmado());
    }

    @Override
    public void eliminar(Pedido pedido) {
        pedido.getServicio().eliminar(pedido);
    }

        @Override
    public String getNombre() {
        return "No Confirmado";
    }

}
