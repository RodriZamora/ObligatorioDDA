package dominio;

import dominio.Servicio;

public class ClienteFrecuente implements TipoCliente {

    @Override
    public Beneficio calcularBeneficio(Servicio servicio) {
        double monto = 0;
        for (Pedido p : servicio.getPedidos()) {
            if (p.getItemMenu().getNombre().equalsIgnoreCase("Café")) {
                monto += p.getItemMenu().getPrecioUnitario();
            }
        }
        return new Beneficio("Café invitación", monto);
    }

}
