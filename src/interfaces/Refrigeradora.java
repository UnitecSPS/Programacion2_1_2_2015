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
public class Refrigeradora implements InterZombiable {

    @Override
    public String getIp() {
        return "192.168.3.3";
    }

    @Override
    public int connect() {
        System.out.println("Connecting to LG Services");
        return 202;
    }

    @Override
    public void sendRequest() {
        System.out.println("Sending Recipe to my Owner Email");
    }

    @Override
    public void convertir() {
        System.out.println("Me convierto en Blu y boto el hielo");
    }

    @Override
    public void queComo() {
        System.out.println("Me como la carne que este en el freezer");
    }

    @Override
    public void mixin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
