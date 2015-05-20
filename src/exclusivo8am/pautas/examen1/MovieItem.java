/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.pautas.examen1;

import java.util.Calendar;

/**
 *
 * @author Docente 17082011
 */
public class MovieItem extends BlockBusterItem {
    private String estado;
    
    public MovieItem(int c, String n, double p){
        super(c,n,p);
        estado = "ESTRENO";
    }
    
    @Override
    public String toString(){
        return super.toString()+estado+"-Movie";
    }
    
    @Override
    public double pagoRenta(int dias){
        if(estado.equals("ESTRENO") && dias > 2)
            return precio + (dias - 2)*50;
        else if(estado.equals("NORMAL") && dias > 5)
            return precio + (dias-5) * 30;
        else
            return precio;
    }
    
    public void evaluarEstado(){
        Calendar hoy = Calendar.getInstance();
        hoy.add(Calendar.MONTH, -5);
        if(hoy.after(fecha))
            estado = "NORMAL";
    }
    
}
