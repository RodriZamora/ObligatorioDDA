package dominio;

import dominio.EstadoDispositivo;
import excepciones.DispositivoException;

public class EstadoDispositivoOcupado extends EstadoDispositivo {

    public EstadoDispositivoOcupado(Dispositivo dispositivo) {
        super(dispositivo, "OCUPADO", Dispositivo.Estados.Ocupado);
    }

    @Override
    public void liberar() throws DispositivoException {
        //throw new DispositivoException("Dispositivo ya está libre");
        getDispositivo().cambiarEstado(new EstadoDispositivoLiberado(getDispositivo()));
    }

    @Override
    public void ocupar() throws DispositivoException {
        //getDispositivo().cambiarEstado(new EstadoDispositivoOcupado(getDispositivo()));
    }

}
