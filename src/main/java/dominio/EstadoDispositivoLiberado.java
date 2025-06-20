package dominio;

import dominio.EstadoDispositivo;
import excepciones.DispositivoException;

public class EstadoDispositivoLiberado extends EstadoDispositivo {

    public EstadoDispositivoLiberado(Dispositivo dispositivo) {
        super(dispositivo, "DISPONIBLE", Dispositivo.Estados.Disponible);
    }

    @Override
    public void liberar() {
        //getDispositivo().cambiarEstado(new EstadoDispositivoLiberado(getDispositivo()));
    }

    @Override
    public void ocupar() throws DispositivoException  {
        //throw new DispositivoException("El dispositivo ya está ocupado");
        getDispositivo().cambiarEstado(new EstadoDispositivoOcupado(getDispositivo()));
    }

}
