/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.archivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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
                System.out.println("Lo quiere borrar?: ");
                if( lea.next().equals("SI")){
                    if( file.delete() )
                        System.out.println("Se borro bien!");
                }
                    
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
            crear = file.mkdirs();
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
        System.out.println("Padre: " + file.getAbsoluteFile().getParentFile().getName());
        System.out.println("Mide " + file.length()+" bytes");
        if(file.isFile())
            System.out.println("Es un archivo");
        if(file.isDirectory()){
            System.out.println("Es un folder");
            dir(file);
        }
        if(file.isHidden())
            System.out.println("Esta Oculto");
        System.out.println("Ultima Modificacion: " + 
                new Date(file.lastModified()));
    }

    private static void dir(File dir) {
        System.out.println("Quiere imprimir su contenido?: ");
        if(lea.next().equals("SI")){
            dir2(dir);
            tree(dir,"");
        }
    }

    private static void dir2(File dir) {
        int files=0, dirs=0;
        long tbytes=0;
        
        for(File child : dir.listFiles()){
            if(!child.isHidden()){
                //ultima fecha
                System.out.print(new Date(child.lastModified()));
                System.out.print("    ");
                //ver el tipo
                if(child.isDirectory()){
                    dirs++;
                    System.out.print("<DIR>     ");
                    
                }
                else if(child.isFile()){
                    files++;
                    tbytes += child.length();
                    System.out.print("     "+child.length());
                }
                //nombre
                System.out.println(" "+child.getName());
            }
        }
        System.out.println(files+" archivos   "+tbytes+" bytes");
        System.out.println(dirs+" dirs  "+dir.getTotalSpace()+" bytes libres");
    }

    private static void tree(File dir,String tab) {
        if(dir.isDirectory()){
            System.out.println(tab+dir.getName());
            for(File child : dir.listFiles())
                if(!child.isHidden())
                    tree(child,tab+"-");
        }
    }
}
