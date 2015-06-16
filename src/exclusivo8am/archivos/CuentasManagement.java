/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo8am.archivos;

import java.io.File;
import java.io.FileNotFoundException;
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
            int num = rCuentas.readInt();
            long pos = rCuentas.getFilePointer();
            rCuentas.readUTF();
            rCuentas.seek(rCuentas.getFilePointer()+24);
            if(rCuentas.readBoolean() && num == nc)
                return pos;
        }
        
        return -1;
    }
    
    public void depositar(int nc, double m, String r)throws IOException{
        long pos = search(nc);
        if( pos != -1){
            rCuentas.seek(pos);
            rCuentas.readUTF();
            double saldo = rCuentas.readDouble();
            rCuentas.seek(rCuentas.getFilePointer()-8);
            rCuentas.writeDouble(saldo+m);
            rCuentas.readDouble();
            rCuentas.writeLong(new Date().getTime());
            createTransaction(nc,r,m,TipoTransaccion.DEPOSITO);
        }
    }
    
    public boolean retirar(int nc,double m, String r)throws IOException{
        long pos = search(nc);
        if( pos != -1){
            rCuentas.seek(pos);
            rCuentas.readUTF();
            double saldo = rCuentas.readDouble();
            if( saldo > m){
                rCuentas.seek(rCuentas.getFilePointer()-8);
                rCuentas.writeDouble(saldo-m);
                rCuentas.readDouble();
                rCuentas.writeLong(new Date().getTime());
                createTransaction(nc,r,m,TipoTransaccion.RETIRO);
                return true;
            }  
        }
        return false;
    }

    private void createTransaction(int nc, String r, double m, TipoTransaccion tt) throws IOException{
        try(RandomAccessFile rt = new RandomAccessFile(ROOT_FOLDER+"/transacciones_"+nc+".bac","rw")){
            rt.seek(rt.length());
            //fecha
            rt.writeLong(new Date().getTime());
            //tipo
            rt.writeUTF(tt.name());
            //responsable
            rt.writeUTF(r);
            //monto
            rt.writeDouble(m);
        }    
    }
    
    /**
     * Recorrer TODAS LAS CUENTAS ACTIVAS
     * Y le vamos adicionar al saldo el interes genero
     * interes = saldo * tasa
     * @throws IOException 
     */
    public void registrarIntereses()throws IOException{
        rCuentas.seek(0);
        while(rCuentas.getFilePointer() < rCuentas.length()){
            int nc = rCuentas.readInt();
            rCuentas.readUTF();
            long pos = rCuentas.getFilePointer();
            double sal = rCuentas.readDouble();
            double t = rCuentas.readDouble();
            rCuentas.readLong();
            if(rCuentas.readBoolean()){
                //activa
                rCuentas.seek(pos);
                double inte = sal*t;
                rCuentas.writeDouble(sal+inte);
                //movernos hasta el final del registro
                rCuentas.skipBytes(17);
                createTransaction(nc,"Banco", inte, TipoTransaccion.INTERESES);
            }
        }
    }

    /**
     * Busquen la cuenta bancaria y si existe impriman TODOS sus datos
     * Al final imprimen el LISTADO de transaciones asociadas con TODOS sus
     * datos.
     * AL FINAL IMPRIMIR LO SIGUIENTE:
     *  - La cantidad TOTAL de Transacciones
     *  - Suma del MONTO total de depositos
     *  - Suma del MONTO total de Retiros
     *  - Suma del MONTO total de intereses
     * @param nc 
     */
    void estadoCuenta(int nc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * RECORRE TODAS LAS CUENTAS y si estan activas y
     * su fecha ultima de modificacion fue hace 5 años, la cuenta se
     * inactiva para siempre
     * @throws IOException 
     */
    void desactivar()throws IOException{
        
    }
}
