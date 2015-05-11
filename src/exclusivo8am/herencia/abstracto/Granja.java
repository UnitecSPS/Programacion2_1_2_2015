/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.herencia.abstracto;

/**
 *
 * @author Docente 17082011
 */
public class Granja {
    public static void main(String[] args) {
        Animal ani = new Perro();
        ani.hablar();
        //funciones ON-DEMAND
        Animal am = new Animal(7){
            
            void test(){
                System.out.println("Waka Waka");
            } 
            
            @Override
            public void hablar(){
                test();
            }
        };
        
        am.hablar();
        
        Animal mal = new Animal(5) {

            @Override
            public void hablar() {
                System.out.println("Wiki Wiki");
            }
        };
        
        mal.hablar();
    }
}
