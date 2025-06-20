/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pollo.morfismo;

import dominio.Dispositivo;
import vistas.CrearServicio;
import vistas.MainVistaGestor;


public class PolloMorfismo {

    public static void main(String[] args) {
        DatosPrecarga.cargar();

        for (Dispositivo d : DatosPrecarga.getDispositivos()) {
            CrearServicio vista = new CrearServicio(d);
            vista.setVisible(true);
        }
        MainVistaGestor vistaGestor = new MainVistaGestor();
        vistaGestor.setVisible(true);

    }
}
