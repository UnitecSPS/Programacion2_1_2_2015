/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.memoria;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class PrestamosTest {
    public static void main(String[] args) {
        ArrayListPrestamo list = new ArrayListPrestamo();
        /*Scanner lea = new Scanner(System.in);
        int op;
        
        do{
            System.out.println("1- Agregar prestamo");
            System.out.println("2- Listar Prestamos");
            System.out.println("3- Remover Prestamo");
            System.out.println("4- Agregar Despues de");
            System.out.println("5- Cantidad Total");
            System.out.println("6- Limpiar Lista");
            System.out.println("7- Conseguir Prestamo");
            System.out.println("10-Salir");
            System.out.print("Escoja opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    System.out.print("Nombre: ");
                    String n = lea.next();
                    System.out.print("Monto: ");
                    double m = lea.nextDouble();
                    list.add(new Prestamo(n, m));
                    break;
                case 2:
                    list.print();
                    break;
                case 3:
                    System.out.print("Nombre: ");
                    n = lea.next();
                    if(list.remove(n))
                        System.out.println("Se pudo borrar");
                    else
                        System.out.println("No se encontro");
                    break;
                
            }
        }while(op!=10);*/
        
        list.add( new Prestamo("Alvaro", 5000));
        list.add( new Prestamo("Douglas",3000));
        list.add( new Prestamo("Alejandro", 6500));
        list.add( new Prestamo("Carlos", 2500));
        
        
        list.add("Douglas", new Prestamo("Messi",9000));
        list.add("Messi", new Prestamo("Neymar",9000));
        list.add("Carlos", new Prestamo("Gochez",9000));
        list.add("Bryan", new Prestamo("Eduardo",9000));
        
        list.print();
    }
}
