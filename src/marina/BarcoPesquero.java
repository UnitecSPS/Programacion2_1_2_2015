/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package marina;

/**
 *
 * @author Docente 17082011
 */
public class BarcoPesquero extends Barco {
    private int pecesCapturados;
    public double precioXPescado;
    
    public BarcoPesquero(String n, double pp) {
        super(n);
        pecesCapturados = 0;
        precioXPescado = pp;
    }

    @Override
    public void agregarElemento() {
        pecesCapturados++;
    }

    @Override
    public double vaciarCobrar() {
        double total = pecesCapturados * precioXPescado;
        pecesCapturados=0;
        return total;
    }

    @Override
    public String toString() {
        return "BarcoPesquero={"+super.toString()+" ,Peces Capturados="+
                pecesCapturados + "}"; 
    }
    
    public void agregarCardumen(int c){
        pecesCapturados += c;
    }
    
}
