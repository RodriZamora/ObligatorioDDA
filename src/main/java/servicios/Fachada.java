package servicios;

import observer.Observable;
import observer.Observador;
import dominio.Cliente;
import dominio.Gestor;
import dominio.Categoria;
import dominio.Dispositivo;
import dominio.Insumo;
import dominio.ItemMenu;
import dominio.Pedido;
import dominio.Servicio;
import dominio.Sesion;
import dominio.UnidadProcesadora;
import dominio.Usuario;
import excepciones.DispositivoException;
import excepciones.LoginException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Fachada extends Observable implements Observador {

    private static Fachada instancia = new Fachada();

    private ServicioUsuario servicioUsuario;

    private ServicioServicios servicioServicios;

    private ServicioDispositivo servicioMenu;

    private ServicioDispositivo servicioDispositivo;

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
        servicioUsuario = new ServicioUsuario();
        servicioServicios = new ServicioServicios();
        servicioDispositivo = new ServicioDispositivo();
        servicioMenu = new ServicioDispositivo();
        servicioServicios.agregarObservador(this);
    }

    public Cliente loginCliente(String numeroCliente, String password, Dispositivo dispositivo) throws LoginException, DispositivoException {
        return servicioUsuario.loginCliente(numeroCliente, password, dispositivo);
    }

    public Collection<Categoria> getCategorias() {
        return servicioMenu.getCategorias();
    }

    public void agregarServicio(Servicio servicio) {
        servicioServicios.agregarServicio(servicio);
        servicio.agregarObservador(this);
    }

    public void agregar(Sesion sesion) {
        servicioUsuario.agregar(sesion);
    }

    public void agregar(Dispositivo d1) {
        servicioDispositivo.agregar(d1);
    }

    public void agregar(Cliente c) {
        servicioUsuario.agregar(c);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        avisar(evento);
    }

    public void agregarCategoria(Categoria cat) {
        servicioMenu.agregarCategoria(cat);
    }

    public Usuario obtenerUsuario(String usuario, String password) throws LoginException {
        return servicioUsuario.obtenerUsuario(usuario, password);
    }

    public void agregar(UnidadProcesadora uProcesadora) {
        servicioServicios.agregar(uProcesadora);
    }

    public void agregarGestor(Gestor gestor) {
        servicioUsuario.agregar(gestor);
    }

    public UnidadProcesadora buscarUnidadProcesadora(String up) {
        return servicioServicios.buscarUnidadProcesadora(up);
    }

    public ArrayList<ItemMenu> getItemsDisponibles(Categoria categoria) {
        return servicioMenu.getItemsDisponibles(categoria);
    }

    public Insumo buscarInsumo(String insumo) {
        return servicioMenu.buscarInsumo(insumo);
    }

    public Categoria buscarCategoriaEnServicios(String cat) {
        return servicioMenu.buscarCategoria(cat);
    }

    public void agregarInsumo(Insumo insumo) {
        servicioMenu.agregar(insumo);
    }

    public void agregar(ItemMenu itemMenu) {
        servicioMenu.agregar(itemMenu);
    }

    public ServicioDispositivo getServicioMenu() {
        return servicioMenu;
    }

    public void cerrarSesion(Cliente cliente) {
        servicioUsuario.cerrarSesion(cliente);
    }

    public ArrayList<ItemMenu> getItemsDeCategoria(Categoria categoria) {
        return servicioMenu.getItemsDeCategoria(categoria);
    }

    public void clienteEstalogeado(Cliente cliente, Dispositivo dispositivo) throws LoginException {
        servicioDispositivo.clienteEstaLogeado(cliente, dispositivo);
    }

    public void liberarDispositivo(Cliente cliente) throws DispositivoException {
        servicioDispositivo.liberarDispositivoDeCliente(cliente);
    }

    public ArrayList<Dispositivo> obtenerDispositivos() {
        return servicioDispositivo.obtenerDispositivos();
    }

    public Collection<UnidadProcesadora> getUnidadesProcesadoras() {
        return servicioServicios.getUnidadesProcesadoras();
    }

    public List<Pedido> obtenerPedidosPendientes(UnidadProcesadora up) {
        return servicioServicios.obtenerPedidosPendientes(up);
    }

    public boolean gestorEstaLogueado(Gestor gestor) throws LoginException {
        return servicioUsuario.gestorEstaLogueado(gestor);
    }

    public ArrayList<Pedido> pedidosTomadosGestor(Gestor gestor) {
        return servicioServicios.pedidosTomadosGestor(gestor);
    }

    public void asignarGestorAPedido(Gestor gestor, Pedido pedido) {
        servicioServicios.asignarGestorAPedido(gestor, pedido);
    }

    public void logoutGestor(Gestor gestor) {
        servicioUsuario.logoutGestor(gestor);
    }

}
