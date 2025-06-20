package dominio;

public class Ingrediente {

    private int cantidad;

    private Insumo insumo;

    public Ingrediente(int cantidad, Insumo insumo) {
        this.cantidad = cantidad;
        this.insumo = insumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public boolean tieneStockMinimoInsumo() {
        return insumo.tieneStockMinimo();
    }

    public boolean tieneStock() {
        return insumo.estaDisponible();
    }

    public void descontar() {
        insumo.descontar(cantidad);
    }
    
    public void reintegrarStock(int cantidad) {
        insumo.reintegrarStock(cantidad);
    }

}
