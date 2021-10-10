package practicaIII.utilidades;

import practicaIII.arbol.ArbolAVL;
import practicaIII.dominio.Estacion;
import practicaIII.dominio.Tramo;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utilidades {

    private static Tramo construirTramo(String linea) {
        String[] datosTramo;
        datosTramo = linea.split(":");
        Tramo tramo = null;
        try {
            Estacion estacionA = new Estacion(Integer.parseInt(datosTramo[0]));
            Estacion estacionB = new Estacion(Integer.parseInt(datosTramo[2]));
            tramo = new Tramo(estacionA, Integer.parseInt(datosTramo[1]), estacionB);
        } catch(NumberFormatException e1){
            System.out.println("Error al tratar de ingresar el valor del tiempo de esparción del gas: ");
            e1.printStackTrace(System.out);
        } catch(Exception e2){
            System.out.println("Error al tratar de ingresar el tramo: ");
            e2.printStackTrace(System.out);
        }
        return tramo;
    }

    public static List<Tramo> leerArchivoRutas() {
        List<Tramo> listaTramos = new ArrayList<>();
        File muestras = new File("mapa-estaciones.txt");
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(muestras));
            String linea = bf.readLine();
            while (linea != null) {
                listaTramos.add(construirTramo(linea));
                linea = bf.readLine();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace(System.out);
        } catch (IOException e2) {
            e2.printStackTrace(System.out);
        } finally {
            try {
                bf.close();
            } catch (IOException e3) {
                e3.printStackTrace(System.out);
            }
        }
        return listaTramos;
    }



    public static Integer ingresarEstacionGas(String titulo){
        Integer numEstacion = null;
        do {
            try {
                numEstacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la estación " + titulo + ": "));
            } catch(NumberFormatException e1){
                System.out.println("Error al tratar de ingresar el valor de la estación: ");
                e1.printStackTrace(System.out);
            } catch(Exception e2){
                System.out.println("Error: ");
                e2.printStackTrace(System.out);
            }
        }while(numEstacion == null || numEstacion < 0);
        return numEstacion;
    }

}


