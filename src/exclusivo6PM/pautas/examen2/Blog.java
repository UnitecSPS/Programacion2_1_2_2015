/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.pautas.examen2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 *
 * @author Aula
 */
public class Blog {

    private RandomAccessFile rUsers, rPosts, rComments;
    private BlogUser currentUser;

    public Blog() {
        try {
            rUsers = new RandomAccessFile("usuarios.blo", "rw");
            rPosts = new RandomAccessFile("posts.blo", "rw");
            rUsers = new RandomAccessFile("comments.blo", "rw");

        } catch (IOException e) {

        }
    }

    boolean login(String user, String pass) throws IOException {
        rUsers.seek(0);
        while (rUsers.getFilePointer() < rUsers.length()) {
            String u = rUsers.readUTF();
            String n = rUsers.readUTF();
            String p = rUsers.readUTF();

            if (user.equals(u) && pass.equals(p)) {
                currentUser = new BlogUser(u, n);
                return true;
            }
        }
        return false;
    }

    boolean createAccount(String user, String nom, String pass) throws IOException {
        rUsers.seek(0);
        while (rUsers.getFilePointer() < rUsers.length()) {
            if (rUsers.readUTF().equals(user)) {
                return false;
            }
            rUsers.readUTF();
            rUsers.readUTF();
        }
        rUsers.writeUTF(user);
        rUsers.writeUTF(nom);
        rUsers.writeUTF(pass);
        currentUser = new BlogUser(user, nom);
        return true;
    }

    void crearPost(String title, String cont) throws IOException {
        try {
            int codigo = 0;
            rPosts.seek(0);
            while (rPosts.getFilePointer() < rPosts.length()) {
                codigo = rPosts.readInt();
                rPosts.readUTF();
                rPosts.readLong();
                rPosts.readUTF();
                rPosts.readUTF();
                rPosts.readInt();
            }
            rPosts.writeInt(codigo + 1);
            rPosts.writeUTF(currentUser.username);
            rPosts.writeLong(new Date().getTime());
            rPosts.writeUTF(title);
            rPosts.writeUTF(cont);
            rPosts.writeInt(0);
        } catch (NullPointerException e) {
            System.out.println("Login o Crear primero");
        }
    }

    void miPerfil() throws IOException {
        try {
            System.out.println(currentUser);
            rPosts.seek(0);
            while (rPosts.getFilePointer() < rPosts.length()) {
                int c = rPosts.readInt();
                String u = rPosts.readUTF();
                Date f = new Date(rPosts.readLong());
                String t = rPosts.readUTF();
                rPosts.readUTF();
                int cl = rPosts.readInt();

                if (u.equals(currentUser.username)) {
                    System.out.println(c + "-" + f + "-" + t + "-" + cl);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Login o Crear primero");
        }
    }

    void leerPost(int cp) throws IOException {
        rPosts.seek(0);
        while (rPosts.getFilePointer() < rPosts.length()) {
            int c = rPosts.readInt();
            String u = rPosts.readUTF();
            Date f = new Date(rPosts.readLong());
            String t = rPosts.readUTF();
            String co = rPosts.readUTF();
            int cl = rPosts.readInt();

            if (c == cp) {
                System.out.println("Autor: " + u);
                System.out.println("En: " + f);
                System.out.println(t);
                System.out.println(co);
                rPosts.seek(rPosts.getFilePointer() - 4);
                rPosts.writeInt(cl + 1);

                rComments.seek(0);
                while (rComments.getFilePointer() < rComments.length()) {
                    int cpc = rComments.readInt();
                    String autor = rComments.readUTF();
                    Date fc = new Date(rComments.readLong());
                    String comment = rComments.readUTF();
                    if (cpc == c) {
                        System.out.println(fc + " Autor: " + autor
                                + ": " + comment);
                    }
                }
                break;
            }
        }
    }

    void export(String txtfile) throws IOException {
        try (FileWriter fw = new FileWriter(txtfile)) {
            rPosts.seek(0);
            while (rPosts.getFilePointer() < rPosts.length()) {
                int c = rPosts.readInt();
                String u = rPosts.readUTF();
                Date f = new Date(rPosts.readLong());
                String t = rPosts.readUTF();
                String co = rPosts.readUTF();
                rPosts.readInt();
                fw.write(f + "-" + t + "-" + " Por: " + u
                        + "-" + co);
            }
        }
    }

    void comentar(int cp, String comm) throws IOException {
        try {
            rPosts.seek(0);
            while (rPosts.getFilePointer() < rPosts.length()) {
                int c = rPosts.readInt();
                rPosts.readUTF();
                rPosts.readLong();
                rPosts.readUTF();
                rPosts.readUTF();
                rPosts.readInt();
                if(c == cp){
                    rComments.seek(rComments.length());
                    rComments.writeInt(c);
                    rComments.writeUTF(currentUser.username);
                    rComments.writeLong(new Date().getTime());
                    rComments.writeUTF(comm);
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Login o Crear primero");
        }
    }
}
