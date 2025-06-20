/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import dominio.Gestor;
import dominio.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface PantallaGestor {

    public void mostrarDatosGestor(Gestor gestor);

    public void mostrarPedidosPendientesYSinGestorAsignado(List<Pedido> pendientes);

    public void mostrarPedidosTomados(ArrayList<Pedido> tomados);

    public void limpiarMensajeError();

    public void mostrarMensajeError(String message);

    public void cerrarVista();

}
