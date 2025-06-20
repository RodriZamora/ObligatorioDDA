package dominio;

import java.util.Objects;


public class UnidadProcesadora {

    private String nombre;

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
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
        final UnidadProcesadora other = (UnidadProcesadora) obj;
        return Objects.equals(this.nombre, other.nombre);
    }


}
