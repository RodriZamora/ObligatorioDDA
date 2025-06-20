package dominio;

public class Confirmado extends EstadoPedidoAbstracto {

    @Override
    public void tomar(Pedido pedido) {
        pedido.setEstado(new EnProceso());
    }

    @Override
    public void eliminar(Pedido pedido) {
        pedido.getItemMenu().reintegrarStock();
        pedido.getServicio().eliminar(pedido);
    }

    @Override
    public String getNombre() {
        return "Confirmado";
    }

    @Override
    public boolean esConfirmado() {
        return true;
    }

}
