package dominio;

import java.util.ArrayList;
import java.util.List;

public class ClientePreferencial implements TipoCliente {

    @Override
    public Beneficio calcularBeneficio(Servicio servicio) {
        
        double montoBeneficio = 0;
        List<String> partesDescripcion = new ArrayList<>();

        double descuentoAgua = 0;
        for (Pedido p : servicio.getPedidos()) {
            if ("Agua Mineral".equalsIgnoreCase(p.getItemMenu().getNombre())) {
                descuentoAgua += p.getItemMenu().getPrecioUnitario();
            }
        }
        
        if (descuentoAgua > 0) {
            montoBeneficio += descuentoAgua;
            partesDescripcion.add("Agua gratis (" + String.format("%.2f", descuentoAgua) + ")");
        }

        double total = servicio.calcularTotal();
        if (total > 2000) {
            double descuento5 = total * 0.05;
            montoBeneficio += descuento5;
            partesDescripcion.add("5% de descuento (" + String.format("%.2f", descuento5) + ")");
        }

        String descripcion;
        if (partesDescripcion.isEmpty()) {
            descripcion = "Sin beneficios";
        } else {
            descripcion = String.join(" y ", partesDescripcion);
        }

        return new Beneficio(descripcion, montoBeneficio);

    }

}
