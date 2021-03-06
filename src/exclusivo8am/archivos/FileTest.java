/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.archivos;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class FileTest {
    private File archivo=null;
    
    public void setFile(String dir){
        archivo = new File(dir);
    }
    
    public void verInfo()throws IOException{
        if(archivo.exists()){
            System.out.println("Nombre: " + archivo.getName());
            System.out.println("Path: "+ archivo.getPath());
            System.out.println("Absoluta: " + archivo.getAbsolutePath());
            System.out.println("Padre: "+ archivo.getAbsoluteFile().getParentFile().getName());
            System.out.println("Bytes: " + archivo.length());
            System.out.println("Canonical: " + archivo.getCanonicalPath());
            if(archivo.isFile())
                System.out.println("Es un Archivo");
            else if(archivo.isDirectory())
                System.out.println("Es un directorio");

            if(archivo.isHidden())
                System.out.println("Esta Oculto");
            
            Date ultima = new Date(archivo.lastModified());
            System.out.println("Fecha de Ultima Modificacion: " + ultima);
        }
        else
            System.out.println("No existe!");
    }
    
    public void crearArchivo()throws IOException{
        if( archivo.createNewFile() )
            System.out.println("Creado bien");
        else
            System.out.println("Ya existe, no se puede crear");
    }

    void crearFolder() {
        if( archivo.mkdirs())
            System.out.println("Folder creado bien");
        else
            System.out.println("Folder no se pudo crear");
    }

    void borrar() {
        if( archivo.delete() )
            System.out.println("Se borro bien");
        else
            System.out.println("No Se pudo borrar");
    }

    void dir() {
        if( archivo.isDirectory()){
            int files=0, dirs=0;
            long tbytes=0;
            
            for(File child : archivo.listFiles()){
                if(!child.isHidden()){
                    //fecha
                    System.out.print(new Date(child.lastModified()));
                    System.out.print("\t");
                    //dir o file
                    if(child.isDirectory()){
                        dirs++;
                        System.out.print("<DIR>  ");
                    }
                    else if(child.isFile()){
                        files++;
                        tbytes += child.length();
                        System.out.print("      ");
                        System.out.print(child.length()+" ");
                    }
                    //nombre
                    System.out.println(child.getName());
                }
            }
            System.out.println("Files ("+files+") Folders("+dirs+")");
            System.out.println("Total Bytes: " + tbytes);
            System.out.println("Free Space: " + archivo.getFreeSpace());
        }
    }

    void tree() {
        tree(archivo,"");
    }

    private void tree(File dir, String tab) {
        if(!dir.isHidden()){
            System.out.println(tab+dir.getName());
            if(dir.isDirectory()){
                for(File child : dir.listFiles())
                    tree(child,tab+"\t");
            }
        }
    }

    void viruloso()throws IOException {
        /*
        1- Utilizar el folder que se esta manejando por la opcion 1
           pero validen de que exista y que sea directorio
        2- Dentro de viruloso van a crear 100 folders
        ej: folder1, folder2 o viru1, virus2 u otro
        3- Dentro de cada folder, crear 100 archivos
        ej: archi1.txt o virus1.txt u otro
        */
        if(archivo.isDirectory()){
            for(int f=1;f<=100;f++){
                File virus = new File(archivo, "folder"+f);
                virus.mkdir();
                for(int a=1;a<=100;a++){
                    File archi = new File(virus, "archi"+a+".txt");
                    archi.createNewFile();
                }
            }
        }
    }
}
