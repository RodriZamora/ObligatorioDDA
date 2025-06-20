package dominio;

import excepciones.DispositivoException;

public abstract class EstadoDispositivo {

    private Dispositivo dispositivo;
    private String descripcion;
    private Dispositivo.Estados estado;

    public EstadoDispositivo(Dispositivo dispositivo, String descripcion, Dispositivo.Estados estado) {
        this.dispositivo = dispositivo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Dispositivo.Estados getEstado() {
        return estado;
    }
    
    public abstract void liberar() throws DispositivoException;
    public abstract void ocupar() throws DispositivoException;
}
