/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.prueba2;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class ColeccionEntera extends Collection implements CollectionActions {
    private ArrayList<Integer> numeros;
    
    public ColeccionEntera(String titulo){
        super(titulo,"Entero");
        numeros = new ArrayList<>();
    }
    
    @Override
    void fill() {
        numeros.add(4);
        numeros.add(7);
        numeros.add(2);
        numeros.add(8);
        numeros.add(14);
        
    }

    @Override
    public void print() {
        for(int x : numeros)
            System.out.println(x);
    }
    
}
