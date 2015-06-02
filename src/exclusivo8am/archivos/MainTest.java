/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.archivos;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class MainTest {
    public static void main(String[] args) {
        int op;
        FileTest ft = new FileTest();
        Scanner lea = new Scanner(System.in);
        
        do{
            System.out.println("1- Indicar archivo o directorio");
            System.out.println("2- Ver Informacion");
            System.out.println("3- Crear Archivo");
            System.out.println("4- Crear Folder");
            System.out.println("5- Borrar Archivo o Folder");
            System.out.println("6- Listar Directorio");
            System.out.println("Escoja opcion: ");
            op = lea.nextInt();
            
            try{
                switch(op){
                    case 1:
                        System.out.println("Ingrese direccion: ");
                        ft.setFile(lea.next());
                        break;
                    case 2:
                        ft.verInfo();
                        break;
                    case 3:
                        ft.crearArchivo();
                        break;
                    case 4:
                        ft.crearFolder();
                        break;
                    case 5:
                        ft.borrar();
                        break;
                    case 6:
                        ft.dir();
                        break;
                }
            }
            catch(NullPointerException e){
                System.out.println("Porfavor seleccione la opcion 1 primero");
            }
            catch(IOException e){
                System.out.println("Error de Archivo: "+e.getMessage());
            }
        }while(true);
    }
}
