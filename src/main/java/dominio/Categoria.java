package dominio;

import java.util.ArrayList;

public class Categoria {

    private String nombre;

    private ArrayList<ItemMenu> itemsMenu;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.itemsMenu = new ArrayList<>();
    }

    public Insumo tieneInsumo(String nombre) {
        for (ItemMenu im : itemsMenu) {
            if (im.buscarInsumo(nombre) != null) {
                return im.buscarInsumo(nombre);
            }
        }
        return null;
    }

    public ArrayList<ItemMenu> getItemsMenu() {
        return itemsMenu;
    }

    public ArrayList<ItemMenu> getItemsConStock() {
        ArrayList<ItemMenu> itemsOk = new ArrayList<>();
        for (ItemMenu im : getItemsMenu()) {
            if (im.disponible()) {
                itemsOk.add(im);
            }
        }
        return itemsOk;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Categoria categoria = (Categoria) o;
        return nombre.equalsIgnoreCase(categoria.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }

    public void agregarItem(ItemMenu itemMenu) {
        itemsMenu.add(itemMenu);
    }

}
