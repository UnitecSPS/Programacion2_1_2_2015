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
public class TecnoResidencia implements INetwork {
    
    ArrayList<String> casas = new ArrayList<>();

    @Override
    public void addDevice(String name) {
        casas.add(name);
    }

    @Override
    public void printNetwork() {
        System.out.println("Printing Vecindario");
        for(String h : casas)
            System.out.println("-"+h);
    }

    @Override
    public boolean connectDeviceWith(String d1name, String d2name) {
        return false;
    }

    @Override
    public boolean existDevice(String name) {
        return casas.contains(name);
    }
    
}
