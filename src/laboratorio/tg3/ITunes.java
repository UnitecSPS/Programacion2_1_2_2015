/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.tg3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 *
 * @author Aula
 */
public class ITunes {

    RandomAccessFile rs, rd, rc;

    public ITunes() {
        try {
            rs = new RandomAccessFile("songs.itn", "rw");
            rd = new RandomAccessFile("downloads.itn", "rw");
            rc = new RandomAccessFile("codigos.itn", "rw");
            initCodes();
        } catch (IOException e) {

        }
    }

    private void initCodes() throws IOException {
        if (rc.length() == 0) {
            rc.writeInt(1);
            rc.writeInt(1);
        }
    }

    private int getCodigo(long offset) throws IOException {
        rc.seek(offset);
        int code = rc.readInt();
        rc.seek(offset);
        rc.writeInt(code + 1);
        return code;
    }

    void addSong(String n, String c, double p) throws IOException {
        rs.seek(rs.length());
        //codigo
        rs.writeInt(getCodigo(0));
        //cancion
        rs.writeUTF(n);
        //cantante
        rs.writeUTF(c);
        //precio
        rs.writeDouble(p);
        //estrellas
        rs.writeInt(0);
        //reviews
        rs.writeInt(0);
    }

    private long search(int nc) throws IOException {
        rs.seek(0);
        while (rs.getFilePointer() < rs.length()) {
            if (rs.readInt() == nc) {
                return rs.getFilePointer();
            }
            rs.readUTF();
            rs.readUTF();
            rs.skipBytes(16);
        }
        return -1;
    }

    void reviewSong(int code, int stars) throws IOException {
        if (stars < 0 || stars > 5) {
            throw new IllegalArgumentException(stars + " No es un review valido");
        }

        long pos = search(code);
        if (pos != -1) {
            rs.seek(pos);
            String nc = rs.readUTF();
            rs.readUTF();
            rs.readDouble();
            pos = rs.getFilePointer();
            int ts = rs.readInt();
            int tr = rs.readInt();
            rs.seek(pos);
            rs.writeInt(ts + stars);
            rs.writeInt(tr + 1);
            System.out.println("Se ha dado review a " + nc);
        }
    }

    void downloadSong(int code, String cliente) throws IOException {
        long pos = search(code);

        if (pos != -1) {
            String nc = rs.readUTF();
            rs.readUTF();
            double p = rs.readDouble();

            //crear download
            rd.seek(rd.length());
            //codigo
            rd.writeInt(getCodigo(4));
            //fecha
            rd.writeLong(new Date().getTime());
            //codigo c
            rd.writeInt(code);
            //cliente
            rd.writeUTF(cliente);
            //precio
            rd.writeDouble(p);

            System.out.println("Gracias " + cliente + " por bajar " + nc
                    + " a $" + p);
        } else {
            System.out.println("Cancion no existe");
        }
    }

    void songs(String txtFile) throws IOException {
        rs.seek(0);
        try (FileWriter fw = new FileWriter(txtFile)) {
            String body = "LISTADO DE CANCIONES\n--------------\n";
            while (rs.getFilePointer() < rs.length()) {
                int cc = rs.readInt();
                String nc = rs.readUTF();
                String nca = rs.readUTF();
                double p = rs.readDouble();
                int stars = rs.readInt();
                int revs = rs.readInt();
                double review = revs > 0 ? stars / revs : 0;
                body += cc + "-" + nc + "-" + nca + " $" + p + " Review " + review + "\n";
            }
            System.out.println(body);
            fw.write(body);
        }
    }

    void infoSong(int code) throws IOException {
        long pos = search(code);

        if (pos != -1) {
            String nc = rs.readUTF();
            String nca = rs.readUTF();
            double p = rs.readDouble();
            int stars = rs.readInt();
            int revs = rs.readInt();
            double review = revs > 0 ? stars / revs : 0;
            System.out.println(code + "-" + nc + "-" + nca +
                    " $" + p + " Review " + review + "\n");
            System.out.println("Listado de Downloads\n----------");
            int cd = 0;
            rd.seek(0);
            while(rd.getFilePointer() < rd.length()){
                int cdo = rd.readInt();
                Date fecha = new Date(rd.readLong());
                int cc = rd.readInt();
                String cli = rd.readUTF();
                double pd = rd.readDouble();
                
                if( cc == code ){
                    cd++;
                    System.out.println(cdo+"- Lo Bajo "+cli+" Pagando $"+pd+
                            " en " + fecha);
                }
            }
            System.out.println("Total Downloads: " + cd);
        }
    }
}
