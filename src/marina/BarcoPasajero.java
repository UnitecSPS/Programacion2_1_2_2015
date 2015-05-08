/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package marina;

import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class BarcoPasajero extends Barco {
    private String pasajeros[];
    private double precio;
    private int contador;
    
    public BarcoPasajero(String n, int max, double p) {
        super(n);
        precio = p;
        pasajeros = new String[max];
        contador = 0;
    }

    @Override
    public void agregarElemento() {
        Scanner lea = new Scanner(System.in);
        if(contador < pasajeros.length){
            System.out.print("Ingrese nombre de pasajero: ");
            pasajeros[contador++] = lea.next();
        }
    }

    @Override
    public double vaciarCobrar() {
        double total = contador * precio;
        contador = 0;
        return total;
    }
    
    @Override
    public String toString() {
        return "BarcoPasajero={"+super.toString()+" ,Boletos vendidos="+
                contador + "}"; 
    }
    
    public void listarPasajeros(){
        System.out.println("Listado de Pasajeros\n-------------------");
        for(int p=0;p<contador;p++){
            System.out.println("-"+pasajeros[p]);
        }
    }
}
