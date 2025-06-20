package dominio;

import excepciones.DispositivoException;

public class Dispositivo {

    private String numIdentificador;
    
    private Cliente cliente;

    private EstadoDispositivo estado = new EstadoDispositivoLiberado(this);

    public enum Estados {
        Ocupado, Disponible
    }

    public Dispositivo(String numIdentificador) {
        this.numIdentificador = numIdentificador;
    }

    public String getNumIdentificador() {
        return numIdentificador;
    }

    public Estados getEstado() {
        return estado.getEstado();
    }

    protected void cambiarEstado(EstadoDispositivo estadoNuevo) {
        estado = estadoNuevo;
    }

    public void liberar() throws DispositivoException {
        estado.liberar();
    }

    public void ocupar() throws DispositivoException {
        estado.ocupar();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    

}
