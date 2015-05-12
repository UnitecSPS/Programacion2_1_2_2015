/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

/**
 *
 * @author Docente 17082011
 */
public class Watch implements Interneteable, Zombiable {

    @Override
    public String getIp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int connect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendRequest() {
        System.out.println("Tic Toc Tic Toc Request");
    }

    @Override
    public void convertir() {
        System.out.println("Primero se paran las agujas y se estilla el vidrio");
    }

    @Override
    public void queComo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
