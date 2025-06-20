package dominio;

public class ClienteDeLaCasa implements TipoCliente {

    @Override
    public Beneficio calcularBeneficio(Servicio servicio) {
        double total = servicio.calcularTotal();
        double montoBeneficio = Math.min(500, total);
        return new Beneficio("Consumo gratis $500", montoBeneficio);
    }

}
