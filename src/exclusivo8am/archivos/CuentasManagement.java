/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo8am.archivos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 *
 * @author Aula
 */
public class CuentasManagement {
    /*
     FORMATOS:
     cuentas.bac
     ----------------
     int numero
     String nombre
     double saldo
     double tasa
     long fecha
     boolean activo
    
     codigos.bac
     -------------
     int codigo sec. dispo.
    
     transacciones_nc.bac
     -----------------------
     long fecha
     String tipo
     String responsable
     double monto
     */

    RandomAccessFile rCuentas;
    public static final String ROOT_FOLDER = "cuentas";

    public CuentasManagement() {
        try {
            new File(ROOT_FOLDER).mkdir();
            rCuentas = new RandomAccessFile(ROOT_FOLDER + "/cuentas.bac", "rw");
        } catch (IOException e) {
            System.out.println("NO DEBERIA ENTRAR AQUI");
        }
    }
    
    private int getCodigo()throws IOException{
        int codigo=1;
        try(RandomAccessFile rcods = new RandomAccessFile(ROOT_FOLDER+"/codigos.bac", "rw")){
            if(rcods.length() > 0 ){
                codigo = rcods.readInt();
                rcods.seek(0);
            }
            rcods.writeInt(codigo+1);
        }
        return codigo;
    }

    public void addCuenta(String cliente, double tasa) throws IOException{
        rCuentas.seek(rCuentas.length());
        //numero
        rCuentas.writeInt( getCodigo() );
        //nombre
        rCuentas.writeUTF(cliente);
        //saldo
        rCuentas.writeDouble(500);
        //tasa
        rCuentas.writeDouble(tasa);
        //fecha
        rCuentas.writeLong(new Date().getTime());
        //activo
        rCuentas.writeBoolean(true);
    }
    
    public void listarActivas()throws IOException{
        rCuentas.seek(0);
        
        while(rCuentas.getFilePointer() < rCuentas.length()){
            int nc = rCuentas.readInt();
            String cli = rCuentas.readUTF();
            double saldo = rCuentas.readDouble();
            rCuentas.seek(rCuentas.getFilePointer()+16);
            if(rCuentas.readBoolean())
                System.out.println(nc+"-"+cli+" Lps."+saldo);
        }
    }
    
    public long search(int nc) throws IOException{
        rCuentas.seek(0);
        
        while(rCuentas.getFilePointer() < rCuentas.length()){
            if(rCuentas.readInt() == nc)
                return rCuentas.getFilePointer();
            rCuentas.readUTF();
            rCuentas.seek(rCuentas.getFilePointer()+25);
        }
        
        return -1;
    }
    
    public void depositar(int nc, double m){
        
    }
}
