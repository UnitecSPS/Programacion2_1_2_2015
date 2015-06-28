/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pauta.examenlab2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

public class PSNUsers {
    RandomAccessFile ru;
    HashTable userCods;
    
    public PSNUsers(){
        try {
            ru=new RandomAccessFile("usuarios.psn", "rw");
            reloadHashTable();
        } catch (IOException ex) {
        }
        
    }
    
    private void reloadHashTable()throws IOException{
        userCods=new HashTable();
        ru.seek(0);
        while(ru.getFilePointer()<ru.length()){
            int cod=ru.readInt();
            long pos=ru.getFilePointer();
            ru.readUTF();
            ru.readInt();
            if(ru.readBoolean())
                userCods.add(cod, pos);
        }
    }
    
    public void addUser(String username)throws IOException{
        int cod=0;
        ru.seek(0);
        while(ru.getFilePointer()<ru.length()){
            cod=ru.readInt();
            if(username.equals(ru.readUTF()))
                return;
            ru.readInt();
            ru.readBoolean();
        }
        
        ru.writeInt(cod+1);
        userCods.add(cod+1, ru.getFilePointer());
        ru.writeUTF(username);
        ru.writeInt(0);
        ru.writeBoolean(true);
    }
    
    public void deactivateUser(int cod)throws IOException{
        long pos=userCods.search(cod);
        if(pos!=-1){
            ru.seek(pos);
            ru.readUTF();
            ru.readInt();
            ru.writeBoolean(false);
            userCods.remove(cod);
        }
    }
    
    public void addTrophyTo(int cod, String game, String description, Trophy type)throws IOException{
        long pos=userCods.search(cod);
        if(pos!=-1){
            ru.seek(pos);
            ru.readUTF();
            int tro=ru.readInt();
            ru.seek(ru.getFilePointer()-4);
            ru.writeInt(tro+1);
            
            RandomAccessFile rt=new RandomAccessFile("trophies.psn", "rw");
            rt.seek(rt.length());
            rt.writeInt(cod);
            rt.writeUTF(type.name());
            rt.writeUTF(game);
            rt.writeUTF(description);
            rt.writeLong(new Date().getTime());
        }
    }   
    
    public void player(int cod)throws IOException{
        long pos=userCods.search(cod);
        if(pos!=-1){
            ru.seek(pos);
            System.out.println("Nombre: "+ru.readUTF());
            System.out.println("Cantidad de trofeos: "+ru.readInt());
            
            RandomAccessFile rt=new RandomAccessFile("trophies.psn", "rw");
            int points=0;
            
            rt.seek(0);
            while(rt.getFilePointer()<rt.length()){
                int codp = rt.readInt();
                String tipo=rt.readUTF();
                //acumulo los puntos
                points += Trophy.valueOf(tipo).puntos;
                String game=rt.readUTF();
                String desc=rt.readUTF();
                Date fecha= new Date(rt.readLong());
                
                if(cod==codp){
                  
                    System.out.println("Fecha: "+fecha+" - Tipo: "+tipo+" - Juego: "+game+" - Descripcion: "+desc);
                }
            }
            System.out.println("Puntos Acumulados: " + points);
        }
    }
}
