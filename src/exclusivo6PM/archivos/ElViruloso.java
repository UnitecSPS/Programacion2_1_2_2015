/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.archivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Aula
 */
public class ElViruloso {
    public static void main(String[] args) throws IOException {
        
        Date inicio = new Date();
        File viruloso = new File("Viruloso");
        viruloso.mkdir();
        
        for (int v = 1; v <= 100; v++) {
            File folder = new File(viruloso, "folder"+v);
            folder.mkdir();
            for (int a = 1; a <= 100; a++) {
                File archi = new File(folder, "archivo"+a+".txt");
                archi.createNewFile();
            }
        }
        Date fin = new Date();
        long diff = fin.getTime() - inicio.getTime();
        long segs = diff/1000;
        System.out.println("Se tardo " + segs+" segundos");
    }
}
