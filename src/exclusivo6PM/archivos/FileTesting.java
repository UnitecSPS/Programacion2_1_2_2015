/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.archivos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class FileTesting {
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        do{
            System.out.println("Ingrese la direccion: ");
            String dir = lea.next();
            
            File file = new File(dir);
            
            if(file.exists()){
                System.out.println("Si Existe!");
                verInfo(file);
            }
            else{
                System.out.println("No Existe!");
                System.out.println("Quiere crearlo? ");
                if(lea.next().equals("SI")){
                    try {
                        creacion(file);
                    } catch (IOException ex) {
                        System.out.println("Error: " + 
                                ex.getMessage());
                    }
                }
                
            }
            
        }while(true);
    }

    private static void creacion(File file)throws IOException {
        System.out.println("FILE o DIR? ");
        boolean crear = false;
        
        if(lea.next().equals("FILE")){
            //crear un file
            crear = file.createNewFile();
        }
        else{
            //crear un directorio
            crear = file.mkdir();
        }
        
        if(crear)
            System.out.println("Se creo masiso");
        else
            System.out.println("No se pudo crear");
    }

    private static void verInfo(File file) {
        System.out.println("Nombre: " + file.getName());
        System.out.println("Path: "+ file.getPath());
        System.out.println("Absoluta: " + file.getAbsolutePath());
        System.out.println("Mide " + file.length()+" bytes");
        if(file.isFile())
            System.out.println("Es un archivo");
        if(file.isDirectory())
            System.out.println("Es un folder");
    }
}
