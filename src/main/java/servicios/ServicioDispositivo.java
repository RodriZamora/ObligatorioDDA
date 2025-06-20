package servicios;

import java.util.Collection;
import dominio.Categoria;
import dominio.Cliente;
import dominio.Dispositivo;
import dominio.Insumo;
import dominio.ItemMenu;
import excepciones.DispositivoException;
import excepciones.LoginException;
import java.util.ArrayList;

public class ServicioDispositivo {

    private Collection<Insumo> insumos = new ArrayList<>();
    private Collection<ItemMenu> itemsMenu = new ArrayList<>();
    private Collection<Categoria> categorias = new ArrayList<>();
    private ArrayList<Dispositivo> dispositivos = new ArrayList<>();

    public ServicioDispositivo() {
    }

    public void agregar(Dispositivo d) {
        dispositivos.add(d);
    }

    void agregar(Insumo i) {
        if (!insumos.contains(i)) {
            insumos.add(i);
        }
    }

    public Insumo buscarInsumo(String nombreInsumo) {
        for (Insumo i : insumos) {
            if (i.getNombre() == nombreInsumo) {
                return i;
            }
        }
        return null;
    }

    public void agregar(ItemMenu itemMenu) {
        itemsMenu.add(itemMenu);
    }

    public ArrayList<ItemMenu> getItemsDisponibles(Categoria categoria) {
        ArrayList<ItemMenu> disponibles = new ArrayList<>();
        for (ItemMenu item : categoria.getItemsMenu()) {
            if (item.disponible()) {
                disponibles.add(item);
            }
        }
        return disponibles;
    }

    public Collection<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Collection<Categoria> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<ItemMenu> getItemsDeCategoria(Categoria categoria) {
        ArrayList<ItemMenu> itemsOk = new ArrayList<>();
        for (Categoria c : getCategorias()) {
            if (c.equals(categoria)) {
                itemsOk = c.getItemsConStock();
            }
        }
        return itemsOk;
    }

    public void agregarCategoria(Categoria cat) {
        if (!categorias.contains(cat)) {
            categorias.add(cat);
        }
    }

    public Categoria buscarCategoria(String nombre) {
        for (Categoria c : categorias) {
            if (c.toString().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public void clienteEstaLogeado(Cliente cliente, Dispositivo dispositivo) throws LoginException {
        for (Dispositivo d : dispositivos) {
            if (!d.equals(dispositivo)) {
                if (cliente.equals(d.getCliente())) {
                    throw new LoginException("Ud. ya está identificado en otro dispositivo");
                }
            }
        }
    }

    public void liberarDispositivoDeCliente(Cliente cliente) throws DispositivoException {
        for (Dispositivo d : dispositivos) {
            if (cliente.equals(d.getCliente())) {
                d.liberar();
            }
        }
    }

    public ArrayList<Dispositivo> obtenerDispositivos() {
        return dispositivos;
    }

}
