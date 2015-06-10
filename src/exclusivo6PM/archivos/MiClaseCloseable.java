/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.archivos;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Aula
 */
public class MiClaseCloseable implements Closeable {

    public void create() throws IOException{
        File f = null;//new File("c**arlos.doc");
        f.createNewFile();
    }
    
    @Override
    public void close() throws IOException {
        System.out.println("CERRANDO");
    }

}
