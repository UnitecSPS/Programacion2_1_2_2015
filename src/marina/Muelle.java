/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package marina;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class Muelle {
    static ArrayList<Barco> barcos = new ArrayList<>();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int op;
        
        do{
            System.out.println("1- Agregar Barco");
            System.out.println("2- Agregar Elemento");
            System.out.println("3- Vaciar Barco");
            System.out.println("4- Listar Pasajeros");
            System.out.println("5- Agregar Cardumen");
            System.out.println("6- Salir");
            System.out.println("Escoja opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    System.out.print("Nombre: ");
                    String name = lea.next();
                    System.out.print("Tipo: ");
                    String tipo = lea.next();
                    agregarBarco(name, tipo.toUpperCase());
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    name = lea.next();
                    agregarElemento(name);
                    break;
                case 3:
                    System.out.print("Nombre: ");
                    name = lea.next();
                    System.out.println("Total Generado: " + 
                            vaciarBarco(name));
                    break;
                case 4:
                    listarPasajeros();
                    break;
                case 5:
                    System.out.print("Nombre: ");
                    name = lea.next();
                    System.out.println("Cantidad: ");
                    int cantidad = lea.nextInt();
                    agregarCardumen(name,cantidad);
            }
        }while(op!=6);
    }

    private static Barco search(String name){
        for(Barco b : barcos){
            if(b.getName().equals(name))
                return b;
        }
        return null;
    }
    
    private static void agregarBarco(String name, String tipo) {
        if(search(name) == null){
            
            System.out.println("Precio Elemento: ");
            double p = lea.nextDouble();
            
            switch(tipo){
                case "PESQUERO":
                    barcos.add(new BarcoPesquero(name, p));
                    break;
                case "PASAJERO":
                    System.out.print("Maxima capacidad: ");
                    int max = lea.nextInt();
                    barcos.add(new BarcoPasajero(name, max, p));
                    break;
            }
        }
    }

    private static void agregarElemento(String name) {
        Barco barco = search(name);
        if(barco != null)
            barco.agregarElemento();
    }

    private static double vaciarBarco(String name) {
        Barco barco = search(name);
        if(barco != null){
            System.out.println(barco.toString());
            return barco.vaciarCobrar();
        }
        return 0;
    }

    private static void listarPasajeros() {
        for(Barco barco : barcos){
            if(barco instanceof BarcoPasajero){
                ((BarcoPasajero)barco).listarPasajeros();
            }
        }
    }

    private static void agregarCardumen(String name, int cantidad) {
        Barco barco = search(name);
        if(barco instanceof BarcoPesquero)
            ((BarcoPesquero)barco).agregarCardumen(cantidad);
    }
}
