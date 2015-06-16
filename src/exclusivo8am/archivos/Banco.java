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
            System.out.println("3- Depositar");
            System.out.println("4- Retirar");
            System.out.println("5- Estado de cuenta");
            System.out.println("6- Registrar Intereses");
            System.out.println("7- Desactivar cuentas viejas");
            System.out.println("8- Salir");
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
                    case 3:
                        depositar();
                        break;
                    case 4:
                        retirar();
                        break;
                    case 5:
                        estado();
                        break;
                    case 6:
                        manager.registrarIntereses();
                        break;
                    case 7:
                        manager.desactivar();
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

    private static void depositar()throws IOException {
        System.out.print("Numero Cuenta: ");
        int nc = lea.nextInt();
        System.out.print("Monto: ");
        double m = lea.nextDouble();
        System.out.print("Quien Deposita?: ");
        String cli = lea.next();
        manager.depositar(nc, m, cli);
    }

    private static void retirar()throws IOException {
        System.out.print("Numero Cuenta: ");
        int nc = lea.nextInt();
        System.out.print("Monto: ");
        double m = lea.nextDouble();
        System.out.print("Quien Retira?: ");
        String cli = lea.next();
        if( manager.retirar(nc, m, cli) )
            System.out.println("Retiro con Exito");
        else
            System.out.println("No Existe o no tiene saldo");
    }

    private static void estado() {
        System.out.print("Numero Cuenta: ");
        int nc = lea.nextInt();
        manager.estadoCuenta(nc);
    }
}
