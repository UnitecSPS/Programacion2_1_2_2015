/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.io.Serializable;

/**
 *
 * @author Docente 17082011
 */
public class PS4 extends Consola implements Interneteable, Serializable{

    public PS4() {
        super("PS4");
    }

    @Override
    public String getIp() {
        return "192.168.18.6";
    }

    @Override
    public int connect() {
        System.out.println("Connection to PSN");
        return 200;
    }

    @Override
    public void sendRequest() {
        System.out.println("Sending info to servers");
    }
    
    public void playBlueRay(String d){
        System.out.println("Loading Movie " + d);
    }
    
}
