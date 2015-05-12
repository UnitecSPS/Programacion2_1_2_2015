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
public class Cabotaje {
    public static void main(String[] args) {
        //Funciones ON-DEMAND
        Barco titanice = new Barco("Titanic"){
            public void test(){
                System.out.println("Shuu Shuu Shuuu");
            }

            @Override
            public void agregarElemento() {
                System.out.println("Agregando elemento");
                test();
            }

            @Override
            public double vaciarCobrar() {
                return 5000;
            }
            
            
        };
        
        Barco atom = new Barco("Atom") {

            @Override
            public void agregarElemento() {
                System.out.println("Atom Shu Shu");
            }

            @Override
            public double vaciarCobrar() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        
        titanice.agregarElemento();
        atom.agregarElemento();
    }
}
