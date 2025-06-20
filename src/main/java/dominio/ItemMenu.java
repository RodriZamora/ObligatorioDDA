package dominio;

import java.util.ArrayList;

public class ItemMenu {

    private String nombre;

    private double precioUnitario;

    private ArrayList<Ingrediente> ingredientes;

    private Categoria categoria;

    private UnidadProcesadora unidadProcesadora;

    public ItemMenu(String nombre, double precioUnitario, Categoria categoria, UnidadProcesadora unidadProcesadora) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.categoria = categoria;
        this.unidadProcesadora = unidadProcesadora;
        this.ingredientes = new ArrayList<>();
    }

    public Insumo buscarInsumo(String nombre) {
        for (Ingrediente i : ingredientes) {
            if (i.getInsumo().getNombre().equals(nombre)) {
                return i.getInsumo();
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean estaDisponible() {
        for (Ingrediente i : ingredientes) {
            if (!i.tieneStock()) {
               return true;
            }
        }
        return false;
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    @Override
    public String toString() {
        return nombre;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }

    public void setUnidadProcesadora(UnidadProcesadora unidadProcesadora) {
        this.unidadProcesadora = unidadProcesadora;
    }

    public boolean validar(){
        return this.estaDisponible();
    }

    public boolean disponible() {
        for (Ingrediente i : ingredientes) {

            if (!i.tieneStock()) {
                return false;
            }
        }
        return true;
    }
    
    public void descontarStock() {
        for(Ingrediente i : ingredientes){
            i.descontar();
        }
    }
    
    public void reintegrarStock() {
        for(Ingrediente i : ingredientes){
            i.reintegrarStock(i.getCantidad());
        }
    }

}
