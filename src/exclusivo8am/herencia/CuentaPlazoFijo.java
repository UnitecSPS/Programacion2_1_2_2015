/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.herencia;

import java.util.Calendar;

/**
 *
 * @author Docente 17082011
 */
public final class CuentaPlazoFijo extends CuentaBancaria implements Rateable{
    private Calendar plazoFin;
    private double intereses;
    
    public CuentaPlazoFijo(int n,String c,double s){
        super(n,c,s,0.05);
        plazoFin = Calendar.getInstance();
        intereses = 0;
    }

    public Calendar getPlazoFin() {
        return plazoFin;
    }

    public double getIntereses() {
        return intereses;
    }

    @Override
    public boolean retirar(double m) {
        if(intereses > m){
            intereses -= m;
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @param y fecha con formato dd/mm/aaaa
     */
    public void setPlazoFin(String fecha){
        String datos[] = fecha.split("/");
        int d = Integer.parseInt(datos[0]);
        int m = Integer.parseInt(datos[1]) - 1;
        int y = Integer.parseInt(datos[2]);
        plazoFin.set(y, m, d);
    }
    
    @Override
    public void quienSoy(){
        System.out.println("SOY DE PLAZO FIJO");
    }
    
    @Override
    public String toString(){
        return super.toString() + ", fecha fin: " + plazoFin.getTime();
    }

    @Override
    public void increaseRate() {
        Calendar hoy = Calendar.getInstance();
        
        if(hoy.before(plazoFin))
            intereses += saldo * tasa;
    }
}
