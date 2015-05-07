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
public abstract class Animal {
    int patas;

    public Animal(int patas) {
        this.patas = patas;
    }

    public int getPatas() {
        return patas;
    }
    
    public abstract void hablar();
}
