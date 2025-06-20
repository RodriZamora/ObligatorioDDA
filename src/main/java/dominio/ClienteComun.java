package dominio;

import dominio.Servicio;

public class ClienteComun implements TipoCliente {

    @Override
    public Beneficio calcularBeneficio(Servicio servicio) {
        return new Beneficio("Sin beneficio", 0);
    }



}
