/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.prueba2;

/**
 *
 * @author Docente 17082011
 */
public class ColecctionTest {
    public static void main(String[] args) {
        Collection coll = new ColeccionEntera("Morata");
        coll.fill();
        ((ColeccionEntera)coll).print();
    }
}
