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
public class TecnoResidenciaCoNFiles implements INetwork {

    @Override
    public void addDevice(String name) {
        System.out.println("Adding "+name+" al disco");
    }

    @Override
    public void printNetwork() {
        System.out.println("Abrir el archivo e imprimir su contenido");
    }

    @Override
    public boolean connectDeviceWith(String d1name, String d2name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existDevice(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
