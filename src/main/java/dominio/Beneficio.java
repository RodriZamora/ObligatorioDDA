package dominio;

public class Beneficio {

    private final String descripcion;
    private final double monto;

    public Beneficio(String descripcion, double monto) {
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }

}
