/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.herencia.abstracto;

import marina.Barco;

/**
 *
 * @author Docente 17082011
 */
public abstract class BarcoCarga extends Barco {

    public BarcoCarga(String n) {
        super(n);
    }

    @Override
    public double vaciarCobrar() {
        return 0;
    }
    
}
