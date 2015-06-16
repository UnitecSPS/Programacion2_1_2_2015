/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.archivos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class FicohsaPrestamos {
    static PrestamoManager manager = new PrestamoManager();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        int op = 1;
        
        do{
            System.out.println("1-Agregar Prestamo");
            System.out.println("2-Listar Prestamo");
            System.out.println("3- Abonar");
            System.out.println("4- Estado Cuenta");
            System.out.println("7- Salir");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        agregar();
                        break;
                    case 2:
                        manager.listar();
                        break;
                    case 3:
                        abonar();
                        break;
                    case 4:
                        estado();
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Ingrese un numero");
                lea.next();
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }while(op!=7);
    }

    private static void agregar() throws IOException {
        System.out.println("Tipo: ");
        char t = lea.next().toUpperCase().charAt(0);
        System.out.println("Cliente: ");
        String cli = lea.next();
        System.out.println("Monto total: ");
        double m = lea.nextDouble();
        
        manager.agregarPrestamo(cli, t, m);
    }

    private static void abonar()throws IOException {
        System.out.print("Numero: ");
        int np = lea.nextInt();
        System.out.print("Monto: ");
        double a = lea.nextDouble();
        System.out.print("Quien lo hace? ");
        String quien = lea.next();
        manager.abonar(np, a, quien);
    }

    private static void estado()throws IOException {
        System.out.print("Numero: ");
        int np = lea.nextInt();
        manager.estadoCuenta(np);
    }
}
