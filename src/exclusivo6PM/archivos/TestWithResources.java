/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.archivos;

import java.io.IOException;

/**
 *
 * @author Aula
 */
public class TestWithResources {
    public static void main(String[] args) {
        try(MiClaseCloseable mc = new MiClaseCloseable()){
            mc.create();
        }
        catch(IOException e){
            System.out.println("Lo Atrape!");
        }
    }
}
