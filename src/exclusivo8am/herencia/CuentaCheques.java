/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.herencia;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class CuentaCheques extends CuentaBancaria {
    private ArrayList<Cheque> cheques;
    
    public  CuentaCheques(){
        numero = 1;
    }
    
    public void addCheque(Cheque ch){
        cheques.add(ch);
    }
    
    
}
