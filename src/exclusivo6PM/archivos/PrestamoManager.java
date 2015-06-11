/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.archivos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

/**
 *
 * @author Aula
 */
public class PrestamoManager {
    /*
     FORMATO:
     PRESTAMOS.FCH
     --------------
     INT CODIGO
     CHAR TIPO
     STRING CLIENTE
     LONG FECHA CREACION
     LONG FECHA LIMITE
     DOUBLE MONTO DE PRESTAMO
     DOUBLE MONTO EXTRA
     DOUBLE BALANCE
        
     ABONO_CP.FCH
     -----------------
     LONG FECHA
     STRING FIRMO
     DOUBLE MONTO
     DOUBLE MORA
    
     CODIGOS.FCH
     -----------------
     INT PROX COD DISPONIBLE
     */

    public static final String ROOT_FOLDER = "prestamos";
    RandomAccessFile rPrestamos;

    public PrestamoManager() {
        new File(ROOT_FOLDER).mkdir();
        try {
            rPrestamos = new RandomAccessFile(ROOT_FOLDER + "/prestamos.fch", "rw");
        } catch (IOException e) {
            System.out.println("NO DEBERIA DE LLEGAR AQUI");
        }
    }

    public int getCodigo() throws IOException {
        int codigo = 1;
        try (RandomAccessFile rCods = new RandomAccessFile(ROOT_FOLDER + "/codigos.fch", "rw")) {

            if (rCods.length() > 0) {
                codigo = rCods.readInt();
                rCods.seek(0);
            }
            rCods.writeInt(codigo + 1);
        }

        return codigo;
    }
    
    public void agregarPrestamo(String cli, char ti, double m)throws IOException{
        if(ti != 'A' && ti != 'V' && ti != 'P')
            throw new NoSuchElementException(ti+" No es un tipo correcto de prestamo");
        
        rPrestamos.seek(rPrestamos.length());
        
        //codigo
        rPrestamos.writeInt(getCodigo());
        //tipo
        rPrestamos.writeChar(ti);
        //cliente
        rPrestamos.writeUTF(cli);
        //fecha creacion
        Calendar c = Calendar.getInstance();
        rPrestamos.writeLong(c.getTimeInMillis());
        //fecha expiracion
        c.add(Calendar.YEAR, 5);
        rPrestamos.writeLong(c.getTimeInMillis());
        //monto
        rPrestamos.writeDouble(m);
        //extra
        double extra = getExtra(ti,m);
        rPrestamos.writeDouble(extra);
        //balance
        rPrestamos.writeDouble(m+extra); 
    }

    private double getExtra(char ti, double m) {
        switch(ti){
            case 'A':
                return m * 0.4;
            case 'V':
                return 30000;
        }
        return 0;
    }
    
    public void listar()throws IOException{
        rPrestamos.seek(0);
        while(rPrestamos.getFilePointer() < rPrestamos.length()){
            
        }
    }
}
