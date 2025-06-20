package dominio;

import excepciones.LoginException;

public class Cliente extends Usuario {

    private TipoCliente tipoCliente;
    private final String numeroCliente;

    public Cliente(String numeroCliente, String nombreCompleto, String password) {
        super(nombreCompleto, password);
        this.numeroCliente = numeroCliente;
        this.tipoCliente = new ClienteComun();
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public Beneficio calcularBeneficio(Servicio servicio) {
        return tipoCliente.calcularBeneficio(servicio);
    }

    @Override
    public void validarUsuario(String usuario, String password) throws LoginException {
        if (!getPassword().equals(password) || !getNumeroCliente().equals(usuario)) {
            throw new LoginException("Credenciales incorrectas");
        }
    }

}
