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

    public void agregarPrestamo(String cli, char ti, double m) throws IOException {
        if (ti != 'A' && ti != 'V' && ti != 'P') {
            throw new NoSuchElementException(ti + " No es un tipo correcto de prestamo");
        }

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
        double extra = getExtra(ti, m);
        rPrestamos.writeDouble(extra);
        //balance
        rPrestamos.writeDouble(m + extra);
    }

    private double getExtra(char ti, double m) {
        switch (ti) {
            case 'A':
                return m * 0.4;
            case 'V':
                return 30000;
        }
        return 0;
    }

    public void listar() throws IOException {
        rPrestamos.seek(0);
        while (rPrestamos.getFilePointer() < rPrestamos.length()) {
            int nc = rPrestamos.readInt();
            char tipo = rPrestamos.readChar();
            String cli = rPrestamos.readUTF();
            rPrestamos.skipBytes(16);
            double m = rPrestamos.readDouble();
            rPrestamos.readDouble();
            double bal = rPrestamos.readDouble();

            System.out.println(nc + "-" + cli + " tipo: " + tipo
                    + " Monto Original Lps." + m
                    + " Balance Lps" + bal);
        }
    }

    public long search(int np) throws IOException {
        rPrestamos.seek(0);
        while (rPrestamos.getFilePointer() < rPrestamos.length()) {
            if (rPrestamos.readInt() == np) {
                return rPrestamos.getFilePointer();
            }
            rPrestamos.readChar();
            rPrestamos.readUTF();
            rPrestamos.skipBytes(40);
        }
        return -1;
    }

    public void abonar(int np, double a, String firmo) throws IOException {
        long pos = search(np);
        Date now = new Date();

        if (pos != -1) {
            rPrestamos.readChar();
            rPrestamos.readUTF();
            rPrestamos.readLong();
            long maxima = rPrestamos.readLong();
            rPrestamos.skipBytes(8);
            long poi = rPrestamos.getFilePointer();
            double balance = rPrestamos.readDouble();
            
            double mora = 0;
            if (now.getTime() > maxima) {
                mora = a * 0.2;
                a = a * 0.8;   
            }
            
            if (a > balance) {
                a = balance;
            }
            rPrestamos.seek(poi);
            rPrestamos.writeDouble(balance - a);
            createAbonoRegistro(np,a,mora,firmo,now);
        }
    }

    private void createAbonoRegistro(int np, double a, double mora, String firmo, Date now) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void estadoCuenta(int np){
        /*
        1-Imprimir TODOS los datos del prestamo
        2- Imprimir el Listado de abonos hechos a este prestamo
        */
    }

}
