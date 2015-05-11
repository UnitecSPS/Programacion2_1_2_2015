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
public class Perro extends Animal {

    public Perro() {
        super(4);
    }

    @Override
    public void hablar() {
        //super.hablar();
        System.out.println("Guaus Guau Guau");
    }
    
}
