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
public class NetworkSolution {
    public static void main(String[] args) {
        ArrayList<INetwork> redes = new ArrayList<>();
        
        redes.add( new TecnoResidenciaCoNFiles() );
        redes.add( new ComputerDevice("Macbook") );
        redes.add( new MachineStates() );
        redes.add( new INetwork() {

            @Override
            public void addDevice(String name) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void printNetwork() {
                System.out.println("On Demand Network");
            }

            @Override
            public boolean connectDeviceWith(String d1name, String d2name) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean existDevice(String name) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        } );
        
        for(INetwork in : redes){
            in.printNetwork();
            if(in instanceof ElectronicDevice)
                System.out.println("Volts = " + 
                        ((ElectronicDevice)in).getvolts());
            if(in instanceof ComputerDevice)
                ((ComputerDevice)in).formatDisc("FAt-32");
            if(in instanceof ISecureNetwork)
                System.out.println(((ISecureNetwork)in).getEncryptedMethod());
            
        }
    }
}
