package servicios;

import dominio.Cliente;
import dominio.EventosPedido;
import dominio.Gestor;
import dominio.Pedido;
import java.util.Collection;
import dominio.Servicio;
import dominio.UnidadProcesadora;
import java.util.ArrayList;
import java.util.List;
import observer.Observable;
import observer.Observador;

public class ServicioServicios extends Observable implements Observador {

    private Collection<Servicio> servicios = new ArrayList<>();
    private Collection<UnidadProcesadora> unidadesProcesadoras = new ArrayList<>();

    public Collection<Servicio> getServicios() {
        return servicios;
    }

    public Collection<UnidadProcesadora> getUnidadesProcesadoras() {
        return unidadesProcesadoras;
    }

    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
        servicio.agregarObservador(this);
        avisar(EventosPedido.ALTA_PEDIDO);
    }

    public void agregar(UnidadProcesadora uProcesadora) {
        unidadesProcesadoras.add(uProcesadora);
    }

    public Servicio obtenerServicioDeCliente(Cliente cliente) {
        for (Servicio s : servicios) {
            if (s.getCliente().equals(cliente)) {
                return s;
            }
        }
        return null;
    }

    public UnidadProcesadora buscarUnidadProcesadora(String up) {
        for (UnidadProcesadora unidad : unidadesProcesadoras) {
            if (unidad.getNombre().equals(up)) {
                return unidad;
            }
        }
        return null;
    }

    public List<Pedido> obtenerPedidosPendientes(UnidadProcesadora up) {
        List<Pedido> pendientes = new ArrayList<>();
        for (Servicio s : servicios) {
            for (Pedido p : s.getPedidos()) {
                UnidadProcesadora unidadP = p.getItemMenu().getUnidadProcesadora();
                boolean esMiUp = unidadP.equals(up);
                boolean sinGestor = p.getGestorAsignado() == null;
                if (esMiUp && sinGestor && p.estaConfirmado() && !p.estaEntregado() && !p.estaFinalizado() && !p.enProceso()) {
                    pendientes.add(p);
                }
            }
        }
        return pendientes;
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (EventosPedido.ALTA_PEDIDO.equals(evento) || EventosPedido.BAJA_PEDIDO.equals(evento) || EventosPedido.ACTUALIZACION_PEDIDO.equals(evento)) {
            avisar(evento);
        }

    }

    public ArrayList<Pedido> pedidosTomadosGestor(Gestor gestor) {
        ArrayList<Pedido> tomados = new ArrayList<>();

        for (Servicio s : servicios) {
            for (Pedido p : s.getPedidos()) {
                if (gestor.equals(p.getGestorAsignado())) {
                    if (p.estaEntregado() || p.estaFinalizado() || p.enProceso()) {
                        tomados.add(p);
                    }
                }
            }
        }
        return tomados;
    }

    void asignarGestorAPedido(Gestor gestor, Pedido pedido) {
        for(Servicio s:servicios){
            for(Pedido p:s.getPedidos()){
                if(pedido.equals(p)){
                    p.setGestorAsignado(gestor);
                }
            }
        }
    }

}
