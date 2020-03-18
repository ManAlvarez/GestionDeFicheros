/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.lecturaescrituradedatosbinarios.serializable;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author manuel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menu();

    }

    private static void menu() {

        String opcion = "";

        while (!opcion.matches("^[0-3]")) {
            System.out.println("########## MENU ##########");
            System.out.println("0. Salir.");
            System.out.println("1. Mostrar os equipos informáticos dunha tenda.");
            System.out.println("2. Eliminar un equipo informático da tenda.");
            System.out.println("3. Engadir un equipo informático da tenda.");
            System.out.println("Selecciona una opción: ");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextLine();
        }

        switch (opcion) {
            case "1":
                mostrarEquipos(selectEquipos());
                menu();
                break;
            case "2":
                engadirEquipos(eliminarEquipos(selectEquipos()));
                menu();
                break;
            case "3":
                engadirEquipos(insertarEquipo(selectEquipos()));
                menu();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                break;
        }
    }

    private static int insertarDatosInt(String informacion) {
        System.out.println(informacion);
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int numInt = -1;
        try {
            numInt = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            System.out.println("Debes insertar un número :" + e);
            insertarDatosInt(informacion);
        }
        return numInt;
    }

    private static double insertarDatosDouble(String informacion) {
        System.out.println(informacion);
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        double numDouble = -1;
        try {
            numDouble = Double.parseDouble(num);
        } catch (NumberFormatException e) {
            System.out.println("Debes insertar un número :" + e);
            insertarDatosDouble(informacion);
        }
        return numDouble;
    }

    private static String insertarDatosString(String informacion) {
        System.out.println(informacion);
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        return cadena;
    }

    private static ArrayList<Equipo> insertarEquipo(ArrayList<Equipo> equipos) {

        int id = insertarDatosInt("Inserta el id del equipo: ");
        String desc = insertarDatosString("Inserta la descripcion del equipos: ");
        double prezo = insertarDatosDouble("Inserta el prezo del producto: ");
        int cantidade = insertarDatosInt("Inserta a cantidade de equipos: ");
        Equipo equipo = new Equipo(id, desc, prezo, cantidade);
        equipos.add(equipo);
        return equipos;
    }

    private static ArrayList<Equipo> selectEquipos() {

        ArrayList<Equipo> equipos = new ArrayList<Equipo>();

        File archivo = new File("equipo1.dat");

        if (!archivo.exists()) {
            return equipos;
        }

        try {
            FileInputStream flujoEntrada = new FileInputStream(archivo);
            ObjectInputStream flujoEntradaDatos = new ObjectInputStream(flujoEntrada);
            try {
                while (true) {
                    Equipo equipoAux = (Equipo) flujoEntradaDatos.readObject();
                    equipos.add(equipoAux);
                }
            } catch (ClassNotFoundException | EOFException e) {
            }
            flujoEntradaDatos.close();

        } catch (IOException e) {
            System.out.println("Error en la E/S de datos : " + e);
        }
        return equipos;
    }

    public static void mostrarEquipos(ArrayList<Equipo> equipos) {
        System.out.println("Equipos: ");
        if (equipos.size() == 0) {
            System.out.println("No hay equipos.");
        }
        for (Equipo equipo : equipos) {
            System.out.println(equipo.getIdentificador() + " " + equipo.getDescripcion() + " " + equipo.getPrezo() + " " + equipo.getCantidade());
        }
    }

    private static ArrayList<Equipo> eliminarEquipos(ArrayList<Equipo> equipos) {

        int id = insertarDatosInt("Inserta el id del equipo que quieres eliminar");
        for (Equipo equipo : equipos) {
            if (equipo.getIdentificador() == id) {
                equipos.remove(equipo);
                break;
            }
        }
        return equipos;
    }

    private static void engadirEquipos(ArrayList<Equipo> equipos) {

        File archivo = new File("equipo1.dat");
        try {
            FileOutputStream flujoSalida = new FileOutputStream(archivo);
            ObjectOutputStream flujoSalidaDatos = new ObjectOutputStream(flujoSalida);

            for (Equipo equipo : equipos) {
                flujoSalidaDatos.writeObject(equipo);          
            }
            flujoSalidaDatos.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e);
        } catch (IOException e) {
            System.out.println("Error de E/S : " + e);
        }
    }
}
