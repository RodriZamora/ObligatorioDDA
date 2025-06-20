/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pollo.morfismo;

import dominio.Categoria;
import dominio.Cliente;
import dominio.ClienteComun;
import dominio.ClienteDeLaCasa;
import dominio.ClienteFrecuente;
import dominio.ClientePreferencial;
import dominio.Dispositivo;
import dominio.Gestor;
import dominio.Ingrediente;
import dominio.Insumo;
import dominio.ItemMenu;
import dominio.UnidadProcesadora;
import java.util.ArrayList;
import java.util.Collection;
import servicios.Fachada;

/**
 *
 * @author ASUS
 */
public class DatosPrecarga {

    private static final ArrayList<Dispositivo> dispositivos = Fachada.getInstancia().obtenerDispositivos();
    private static final Collection<UnidadProcesadora> unidadesProcesadoras = Fachada.getInstancia().getUnidadesProcesadoras();

    public static void cargar() {

        precargaDispositivos();
        precargaClientes();
        precargaCategorias();
        precargaUnidadesProcesadoras();
        precargaGestores();
        precargaItemsMenu();
    }

    public static ArrayList<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    private static void precargaDispositivos() {
        Dispositivo d1 = new Dispositivo("1");
        Dispositivo d2 = new Dispositivo("2");
        Dispositivo d3 = new Dispositivo("3");
        Dispositivo d4 = new Dispositivo("4");

        dispositivos.add(d1);
        dispositivos.add(d2);
        dispositivos.add(d3);
        dispositivos.add(d4);
    }

    private static void precargaClientes() {
        Fachada f = Fachada.getInstancia();

        Cliente max = new Cliente("1", "Max Verstappen", "verstappen");
        f.agregar(max);
        max.setTipoCliente(new ClienteDeLaCasa());

        Cliente tsunoda = new Cliente("2", "Yuki Tsunoda", "tsunoda");
        f.agregar(tsunoda);
        tsunoda.setTipoCliente(new ClientePreferencial());

        Cliente hamilton = new Cliente("3", "Lewis Hamilton", "hamilton");
        f.agregar(hamilton);
        hamilton.setTipoCliente(new ClienteComun());

        Cliente norris = new Cliente("4", "Lando Norris", "norris");
        f.agregar(norris);
        norris.setTipoCliente(new ClienteFrecuente());
    }

    private static void precargaCategorias() {
        Fachada f = Fachada.getInstancia();
        Categoria entradas = new Categoria("Entradas");
        f.agregarCategoria(entradas);

        Categoria platosPrincipales = new Categoria("Platos principales");
        f.agregarCategoria(platosPrincipales);

        Categoria postres = new Categoria("Postres");
        f.agregarCategoria(postres);

        Categoria bebidas = new Categoria("Bebidas");
        f.agregarCategoria(bebidas);

        Categoria vinos = new Categoria("Vinos");
        f.agregarCategoria(vinos);

        Categoria cafes = new Categoria("Cafés");
        f.agregarCategoria(cafes);
    }

    private static void precargaUnidadesProcesadoras() {

        UnidadProcesadora cocina = new UnidadProcesadora("Cocina");
        UnidadProcesadora bar = new UnidadProcesadora("Bar");
        UnidadProcesadora caja = new UnidadProcesadora("Caja");
        unidadesProcesadoras.add(cocina);
        unidadesProcesadoras.add(bar);
        unidadesProcesadoras.add(caja);
    }

    private static void precargaGestores() {
        Fachada f = Fachada.getInstancia();

        UnidadProcesadora cocina = f.buscarUnidadProcesadora("Cocina");
        UnidadProcesadora bar = f.buscarUnidadProcesadora("Bar");
        UnidadProcesadora caja = f.buscarUnidadProcesadora("Caja");

        Gestor gestor1 = new Gestor("zamora", "Rodrigo Zamora", "zamora", cocina);
        Gestor gestor2 = new Gestor("wolf", "Toto Wolff", "wolf", cocina);
        Gestor gestor3 = new Gestor("garcia", "Alejandro Garcia", "2", bar);
        Gestor gestor4 = new Gestor("perez", "Sergio Perez", "perez", bar);
        Gestor gestor5 = new Gestor("horner", "Christian Horner", "3", caja);

        f.agregarGestor(gestor1);
        f.agregarGestor(gestor2);
        f.agregarGestor(gestor3);
        f.agregarGestor(gestor4);
        f.agregarGestor(gestor5);
    }

    private static void precargaItemsMenu() {
        Fachada f = Fachada.getInstancia();

        // Precarga de insumos con stock variado (stock mínimo, stock actual)
        f.agregarInsumo(new Insumo("Pan", 2, 8));
        f.agregarInsumo(new Insumo("Queso", 4, 10));
        f.agregarInsumo(new Insumo("Tomate", 3, 7));
        f.agregarInsumo(new Insumo("Pollo", 2, 5));
        f.agregarInsumo(new Insumo("Papa", 1, 3));
        f.agregarInsumo(new Insumo("Café", 2, 4));
        f.agregarInsumo(new Insumo("Chocolate", 1, 2));
        f.agregarInsumo(new Insumo("Vino", 4, 15));
        f.agregarInsumo(new Insumo("Hielo", 4, 10));

        f.agregarInsumo(new Insumo("Carne", 3, 10));
        f.agregarInsumo(new Insumo("Harina", 2, 12));
        f.agregarInsumo(new Insumo("Huevo", 2, 8));
        f.agregarInsumo(new Insumo("Leche", 2, 10));
        f.agregarInsumo(new Insumo("Lechuga", 1, 6));
        f.agregarInsumo(new Insumo("Azúcar", 1, 8));
        f.agregarInsumo(new Insumo("Fruta Mixta", 2, 8));
        f.agregarInsumo(new Insumo("Cerveza", 3, 20));
        f.agregarInsumo(new Insumo("Té", 2, 6));
        f.agregarInsumo(new Insumo("Limonada", 2, 5));

        // Buscar insumos
        Insumo pan = f.buscarInsumo("Pan");
        Insumo queso = f.buscarInsumo("Queso");
        Insumo tomate = f.buscarInsumo("Tomate");
        Insumo pollo = f.buscarInsumo("Pollo");
        Insumo papa = f.buscarInsumo("Papa");
        Insumo cafe = f.buscarInsumo("Café");
        Insumo chocolate = f.buscarInsumo("Chocolate");
        Insumo vino = f.buscarInsumo("Vino");
        Insumo hielo = f.buscarInsumo("Hielo");

        Insumo carne = f.buscarInsumo("Carne");
        Insumo harina = f.buscarInsumo("Harina");
        Insumo huevo = f.buscarInsumo("Huevo");
        Insumo leche = f.buscarInsumo("Leche");
        Insumo lechuga = f.buscarInsumo("Lechuga");
        Insumo azucar = f.buscarInsumo("Azúcar");
        Insumo frutas = f.buscarInsumo("Fruta Mixta");
        Insumo cerveza = f.buscarInsumo("Cerveza");
        Insumo te = f.buscarInsumo("Té");
        Insumo limonada = f.buscarInsumo("Limonada");

        // Unidades procesadoras
        UnidadProcesadora cocina = f.buscarUnidadProcesadora("Cocina");
        UnidadProcesadora bar = f.buscarUnidadProcesadora("Bar");

        // Categorías
        Categoria entradas = f.buscarCategoriaEnServicios("Entradas");
        Categoria platos = f.buscarCategoriaEnServicios("Platos principales");
        Categoria postres = f.buscarCategoriaEnServicios("Postres");
        Categoria bebidas = f.buscarCategoriaEnServicios("Bebidas");
        Categoria vinos = f.buscarCategoriaEnServicios("Vinos");
        Categoria cafes = f.buscarCategoriaEnServicios("Cafés");

        // ITEMS: 
        ItemMenu entrada1 = new ItemMenu("Tostadas con queso", 150, entradas, cocina);
        entrada1.agregarIngrediente(new Ingrediente(1, pan));
        entrada1.agregarIngrediente(new Ingrediente(1, queso));
        f.agregar(entrada1);
        entradas.agregarItem(entrada1);

        ItemMenu entrada2 = new ItemMenu("Ensalada Caprese", 180, entradas, cocina);
        entrada2.agregarIngrediente(new Ingrediente(1, tomate));
        entrada2.agregarIngrediente(new Ingrediente(1, queso));
        f.agregar(entrada2);
        entradas.agregarItem(entrada2);

        ItemMenu plato1 = new ItemMenu("Pollo al horno", 400, platos, cocina);
        plato1.agregarIngrediente(new Ingrediente(1, pollo));
        f.agregar(plato1);
        platos.agregarItem(plato1);

        ItemMenu plato2 = new ItemMenu("Puré de papas", 280, platos, cocina);
        plato2.agregarIngrediente(new Ingrediente(1, papa));
        f.agregar(plato2);
        platos.agregarItem(plato2);

        ItemMenu postre1 = new ItemMenu("Mousse de chocolate", 220, postres, cocina);
        postre1.agregarIngrediente(new Ingrediente(1, chocolate));
        f.agregar(postre1);
        postres.agregarItem(postre1);

        ItemMenu bebida1 = new ItemMenu("Café Express", 120, cafes, bar);
        bebida1.agregarIngrediente(new Ingrediente(1, cafe));
        f.agregar(bebida1);
        cafes.agregarItem(bebida1);

        ItemMenu bebida2 = new ItemMenu("Copa de vino", 200, vinos, bar);
        bebida2.agregarIngrediente(new Ingrediente(1, vino));
        f.agregar(bebida2);
        vinos.agregarItem(bebida2);

        ItemMenu agua = new ItemMenu("Agua Mineral", 150, bebidas, bar);
        bebida2.agregarIngrediente(new Ingrediente(1, hielo));
        f.agregar(agua);
        bebidas.agregarItem(agua);

        ItemMenu entrada3 = new ItemMenu("Empanadas de carne", 120, entradas, cocina);
        entrada3.agregarIngrediente(new Ingrediente(1, harina));
        entrada3.agregarIngrediente(new Ingrediente(1, carne));
        f.agregar(entrada3);
        entradas.agregarItem(entrada3);

        ItemMenu plato3 = new ItemMenu("Hamburguesa con queso", 350, platos, cocina);
        plato3.agregarIngrediente(new Ingrediente(1, pan));
        plato3.agregarIngrediente(new Ingrediente(1, carne));
        plato3.agregarIngrediente(new Ingrediente(1, queso));
        f.agregar(plato3);
        platos.agregarItem(plato3);

        ItemMenu plato4 = new ItemMenu("Spaghetti Bolognesa", 360, platos, cocina);
        plato4.agregarIngrediente(new Ingrediente(1, carne));
        plato4.agregarIngrediente(new Ingrediente(1, tomate));
        f.agregar(plato4);
        platos.agregarItem(plato4);

        ItemMenu plato5 = new ItemMenu("Ensalada César", 200, platos, cocina);
        plato5.agregarIngrediente(new Ingrediente(1, lechuga));
        plato5.agregarIngrediente(new Ingrediente(1, pollo));
        plato5.agregarIngrediente(new Ingrediente(1, queso));
        f.agregar(plato5);
        platos.agregarItem(plato5);

        ItemMenu postre2 = new ItemMenu("Flan casero", 180, postres, cocina);
        postre2.agregarIngrediente(new Ingrediente(1, leche));
        postre2.agregarIngrediente(new Ingrediente(1, huevo));
        postre2.agregarIngrediente(new Ingrediente(1, azucar));
        f.agregar(postre2);
        postres.agregarItem(postre2);

        ItemMenu postre3 = new ItemMenu("Helado de vainilla", 200, postres, cocina);
        postre3.agregarIngrediente(new Ingrediente(1, leche));
        postre3.agregarIngrediente(new Ingrediente(1, azucar));
        f.agregar(postre3);
        postres.agregarItem(postre3);

        ItemMenu bebida4 = new ItemMenu("Limonada natural", 90, bebidas, bar);
        bebida4.agregarIngrediente(new Ingrediente(1, limonada));
        f.agregar(bebida4);
        bebidas.agregarItem(bebida4);

        ItemMenu bebida5 = new ItemMenu("Té verde", 80, bebidas, bar);
        bebida5.agregarIngrediente(new Ingrediente(1, te));
        bebida5.agregarIngrediente(new Ingrediente(1, azucar));
        f.agregar(bebida5);
        bebidas.agregarItem(bebida5);

        ItemMenu bebida6 = new ItemMenu("Cerveza artesanal", 180, bebidas, bar);
        bebida6.agregarIngrediente(new Ingrediente(1, cerveza));
        bebida6.agregarIngrediente(new Ingrediente(1, hielo));
        f.agregar(bebida6);
        bebidas.agregarItem(bebida6);

        ItemMenu bebida7 = new ItemMenu("Smoothie de frutas", 160, bebidas, bar);
        bebida7.agregarIngrediente(new Ingrediente(1, frutas));
        bebida7.agregarIngrediente(new Ingrediente(1, hielo));
        f.agregar(bebida7);
        bebidas.agregarItem(bebida7);

    }

}
