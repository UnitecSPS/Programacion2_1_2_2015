/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.pautas.examen1;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class PlanBlackberry extends Plan {
    private ArrayList<String> bbm;
    
    public PlanBlackberry(int nu, String no, String pin){
        super(nu, no, pin);
        bbm = new ArrayList<>();
    }
    
    @Override
    public void imprimir(){
        super.imprimir();
        for(String pin : bbm)
            System.out.println("-"+pin);
    }
    
    @Override
    public double pagoMensual(int mins, int msgs){
        double pago = 40;
        if(mins > 200)
            pago += (mins-200) * 0.8;
        if(msgs > 300)
            pago += (msgs-300) * 0.2;
        return pago;
    }
    
    public boolean addPinAmigo(String pin){
        if(!bbm.contains(pin))
            bbm.add(pin);
    }
}
