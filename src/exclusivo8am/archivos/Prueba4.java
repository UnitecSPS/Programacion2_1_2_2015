/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo8am.archivos;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aula
 */
public class Prueba4 {
    public static void main(String[] args) {
        try {
            retirar(5,200);
        } catch (IOException ex) {
            Logger.getLogger(Prueba4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static boolean retirar(int nc,double monto)throws IOException {
        RandomAccessFile r = new RandomAccessFile("cuentas.bac","rw");
        
        while(r.getFilePointer() < r.length()){
            int num = r.readInt();
            r.readUTF();
            long pos = r.getFilePointer();
            double saldo = r.readDouble();
            r.skipBytes(17);
            
            if(num == nc && saldo > monto){
                r.seek(pos);
                r.writeDouble(saldo-monto);
                return true;
            }
        }
        return false;
    }
}
