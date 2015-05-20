/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.pautas.examen1;

/**
 *
 * @author Docente 17082011
 */
public class VideoGameItem extends BlockBusterItem {
    private String consola;
    public static final String PLAYSTATION="play", XBOX="x", WII="wii";
    
    public VideoGameItem(int c, String n, String co){
        super(c,n,30);
        consola = co;
    }
    
    @Override
    public String toString(){
        return super.toString() + consola+"-Game";
    }
    
    @Override
    public double pagoRenta(int dias){
        return precio * dias;
    }
}
