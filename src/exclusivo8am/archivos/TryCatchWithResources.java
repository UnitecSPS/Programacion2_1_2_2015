/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo8am.archivos;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Aula
 */
public class TryCatchWithResources {
    public static void main(String[] args) {
        
        //FileWriter fw;
        try(TestCloseable tc = new TestCloseable()){
            tc.go();
        }
        catch(IOException e){
            System.out.println(e);
        }
        
        
    }
}
