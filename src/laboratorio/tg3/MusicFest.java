/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.tg3;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class MusicFest {
    static ITunes it = new ITunes();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        int op=1;
        
        do{
            System.out.println("1- Agregar cancion");
            System.out.println("2- Review Cancion");
            System.out.println("3- Bajar Cancion");
            System.out.println("4- Reporte Canciones");
            System.out.println("5- Ver Informacion de Cancion");
            System.out.println("6- Salir");
            System.out.println("Escoja OPcion ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        agregar();
                        break;
                    case 2:
                        review();
                        break;
                    case 3:
                        download();
                        break;
                    case 4:
                        report();
                        break;
                    case 5:
                        info();
                }
            }catch(InputMismatchException e){
                System.out.println("Ingrese un numero");
                if(lea.hasNext())
                    lea.next();
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }while(op != 6);
    }

    private static void agregar()throws IOException {
        System.out.print("Nombre: ");
        String n = lea.next();
        System.out.print("Cantante: ");
        String c = lea.next();
        System.out.println("Precio: ");
        double p = lea.nextDouble();
        it.addSong(n,c,p);
    }

    private static void review()throws IOException {
        System.out.print("Codigo: ");
        int code = lea.nextInt();
        System.out.print("Estrellas (0-5): ");
        int stars = lea.nextInt();
        it.reviewSong(code,stars);
    }

    private static void download()throws IOException {
        System.out.print("Codigo: ");
        int code = lea.nextInt();
        System.out.print("Cliente: ");
        String cliente = lea.next();
        it.downloadSong(code,cliente);
    }

    private static void report()throws IOException {
        System.out.print("Direccion de TXT File: ");
        it.songs(lea.next());
    }

    private static void info()throws IOException {
        System.out.print("Codigo: ");
        int code = lea.nextInt();
        it.infoSong(code);
    }
}
