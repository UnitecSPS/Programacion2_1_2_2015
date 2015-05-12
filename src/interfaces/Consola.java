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
public class Consola {
    protected String version;

    public Consola(String version) {
        this.version = version;
    }
    
    public void play(String disco){
        System.out.println("Jugando " + disco);
    }
}
