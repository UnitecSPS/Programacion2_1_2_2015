/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class WorlWideWeb {
    public static void main(String[] args) {
        ArrayList<Interneteable> devices = new ArrayList<>();
        Interneteable in = new PS4();
        devices.add( in );
        devices.add( new Refrigeradora() );
        Interneteable other = new Interneteable() {

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
                System.out.println("Sending to request to Bill Gates");
            }
        };
        devices.add( other );
        devices.add( new Watch() );
        
        for( Interneteable inte : devices ){
            inte.sendRequest();
            if( inte instanceof Zombiable )
                ((Zombiable)inte).convertir();
            if( inte instanceof Consola )
                ((Consola)inte).play("UNCHARTED");
            if( inte instanceof PS4)
                ((PS4)inte).playBlueRay("AVENGERS");
        }
    }
}
