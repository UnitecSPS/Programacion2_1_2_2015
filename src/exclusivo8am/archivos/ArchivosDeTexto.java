/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo8am.archivos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class ArchivosDeTexto {

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);

        do {
            System.out.println("Direccion: ");
            String path = lea.nextLine();
            System.out.println("1-Escribir\n2-Leer");
            int op = lea.nextInt();
            try {
                switch (op) {
                    case 1:

                        System.out.println("Lo queres append? SI o NO: ");
                        String append = lea.nextLine().toUpperCase();

                        FileWriter fw = new FileWriter(path, append.equals("SI"));
                        String body;

                        do {
                            System.out.println("Cosas a Escribir?: ");
                            body = lea.nextLine();
                            if (body.equals("#$%")) {
                                break;
                            }
                            fw.write(body + "\n");
                            fw.flush();
                        } while (true);

                        fw.close();

                        break;
                    case 2:
                        File f = new File(path);
                        FileReader fr = new FileReader(f);
                        
                        char buffer[]  =new char[(int)f.length()];
                        int caras = fr.read(buffer);
                        System.out.println("Contenido luego de leer: " + caras +
                                " caracteres: ");
                        System.out.println("----------------------------------");
                        System.out.println(buffer);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } while (true);
    }
}
