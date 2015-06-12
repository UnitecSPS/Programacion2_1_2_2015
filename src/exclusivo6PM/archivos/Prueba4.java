/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.archivos;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aula
 */
public class Prueba4 {
    public static void main(String[] args) {
        try {
            abonar(1,5000);
        } catch (IOException ex) {
            Logger.getLogger(Prueba4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void abonar(int cp, double abono)throws IOException {
        Date now = new Date();
        try(RandomAccessFile rp = new RandomAccessFile("prestamos.fch","rw")){
            while(rp.getFilePointer() < rp.length()){
                int np = rp.readInt();
                rp.readChar();
                rp.readUTF();
                rp.readLong();
                long maxima = rp.readLong();
                rp.skipBytes(8);
                long pos = rp.getFilePointer();
                double balance = rp.readDouble();
                
                if(np == cp){
                    //lo encontre
                    if(now.getTime()>maxima)
                        abono = abono*0.8;
                    if(abono > balance)
                        abono = balance;
                    rp.seek(pos);
                    rp.writeDouble(balance-abono);
                    return;
                }
            }
        }
    }
}
