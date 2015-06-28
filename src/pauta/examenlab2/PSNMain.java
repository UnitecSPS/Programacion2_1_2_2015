/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pauta.examenlab2;

import java.util.Scanner;

public class PSNMain {
    public static void main(String[] args) {
        int opc;
        Scanner lea=new Scanner(System.in);
        PSNUsers users=new PSNUsers();
        
        do{
            System.out.println("Menu");
            System.out.println("1- Agregar Usuario");
            System.out.println("2- Desactivar Usuario");
            System.out.println("3- Agregar Trofeo");
            System.out.println("4- Ver Player");
            System.out.println("5- Salir");
            
            System.out.print("Ingrese su opcion: ");
            opc=lea.nextInt();
            
            try{
                switch(opc){
                    case 1:
                        System.out.print("Ingrese el usuario: ");
                        String u=lea.next();
                        users.addUser(u);
                        break;
                    case 2:
                        System.out.print("Ingrese el codigo: ");
                        int cod=lea.nextInt();
                        users.deactivateUser(cod);
                        break;
                    case 3:
                        System.out.print("Ingrese el codigo: ");
                        cod=lea.nextInt();
                        System.out.print("Ingrese el juego: ");
                        String g=lea.next();
                        System.out.print("Ingrese la descripcion: ");
                        String d=lea.next();
                        System.out.print("Ingrese el tipo: ");
                        Trophy tr= Trophy.valueOf(lea.next().toUpperCase());
                        users.addTrophyTo(cod, g, d, tr);
                        break;
                    case 4:
                        System.out.print("Ingrese el codigo: ");
                        cod=lea.nextInt();
                        users.player(cod);
                        break;
                }
            }
            catch(Exception e){
                System.out.println("error: " + e.getMessage());
            }

        }while(opc!=5);
    }
}
