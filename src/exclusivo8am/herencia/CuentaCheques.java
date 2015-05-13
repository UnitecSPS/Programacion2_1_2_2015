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
    
    public  CuentaCheques(int n, String c, double s){
        super(n,c,s,0);
        cheques = new ArrayList<>();
    }
    
    public void addCheque(double m, boolean sp){
        int n = cheques.size()+1;
        Cheque ch = new Cheque(n, "Panchito", m);
        if(!sp) 
            ch.reboto();
        cheques.add(ch);
    }
    
    @Override
    public void quienSoy(){
        System.out.println("SOY DE CHEQUES");
    }

    @Override
    public boolean retirar(double m) {
        boolean paso = super.retirar(m);
        addCheque(m, paso);
        return paso;
    }
    
    
}
