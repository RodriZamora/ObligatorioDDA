package dominio;

import java.util.Objects;

public class Insumo {

    private String nombre;

    private int stockMinimo;

    private int stockActual;

    public Insumo(String nombre, int stockMinimo, int stockActual) {
        this.nombre = nombre;
        this.stockMinimo = stockMinimo;
        this.stockActual = stockActual;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public int getStockActual() {
        return stockActual;
    }

    public boolean tieneStockMinimo() {
        return getStockActual() > getStockMinimo();
    }

    public boolean estaDisponible() {
        return getStockActual() >= getStockMinimo();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Insumo other = (Insumo) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    public void descontar(int cantidad) {
        this.stockActual -= cantidad;
    }
    
    public void reintegrarStock(int cantidad) {
        this.stockActual += cantidad;
    }

}
