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
public class ComputerDevice extends ElectronicDevice 
        implements INetwork, ISecureNetwork, Serializable{

    public ComputerDevice(String name) {
        super(name, "Computer");
    }

    public void formatDisc(String format){
        System.out.println("Formatting the disk with " + format);
    }
    
    @Override
    public void addDevice(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printNetwork() {
        System.out.println("Connecting My Files with INetwork");
    }

    @Override
    public boolean connectDeviceWith(String d1name, String d2name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existDevice(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEncryptedMethod() {
        return "UTF8 Encrypted Script";
    }

    @Override
    public void applyEncryption() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
