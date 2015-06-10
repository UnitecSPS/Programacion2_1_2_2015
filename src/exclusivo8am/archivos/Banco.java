/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo8am.archivos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class Banco {
    static CuentasManagement manager = new CuentasManagement();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        int op=0;
        do{
            System.out.println("1- Agregar Cuenta Bancaria: ");
            System.out.println("2- Listar Cuentas Activas");
            System.out.println("7- Salir");
            System.out.println("Escoja opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        agregar();
                        break;
                    case 2:
                        manager.listarActivas();
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

    private static void agregar()throws IOException {
        System.out.print("Nombre: ");
        String nom = lea.next();
        System.out.print("Tasa propuesta: ");
        double tasa = lea.nextDouble();
        manager.addCuenta(nom, tasa);
    }
}
