/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestingTexto {
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        int op;
        
        File archi = null;
        
        do{
            System.out.println("1- Ingrese Archivo");
            System.out.println("2- Escriba en Dicho Archivo");
            System.out.println("3- Leer de Archivo");
            System.out.println("4- Salir");
            System.out.println("Escoja opcion: ");
            op = lea.nextInt();
            
            try{
                switch(op){
                    case 1:
                        System.out.println("Ingrese Direccion: ");
                        archi = new File(lea.next());
                        break;
                    case 2:
                        escribir(archi);
                        break;
                    case 3:
                        leer(archi);
                        break;
                }
            }
            catch(NullPointerException e){
                System.out.println("Ingrese la opcion 1 primero");
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }while(op!=4);
    }

    private static void escribir(File archi) throws IOException {
        System.out.println("Lo queres append?: ");
        String append = lea.next().toUpperCase();
        
        FileWriter fw= new FileWriter(archi, append.equals("SI"));
        System.out.println("Ingrese texto a escribir:");
        
        do{
            String body = lea.nextLine();
            if(body.equals("#$%"))
                break;
            fw.write(body+"\n");
            fw.flush();
        }while(true);

        fw.close();
    }

    private static void leer(File archi) throws IOException {
        FileReader fr = new FileReader(archi);
        char buffer[] = new char[(int)archi.length()];
        int leido = fr.read(buffer);
        System.out.println("Contenido leido "+leido+" caracteres");
        System.out.println("-------------------------------------");
        System.out.println(buffer);
        fr.close();
    }
}
