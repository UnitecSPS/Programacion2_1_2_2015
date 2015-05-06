/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.herencia;

/**
 *
 * @author Docente 17082011
 */
public class DowncastingTest {
    public static void main(String[] args) {
        //upcasting
        CuentaBancaria cb = new CuentaPlazoFijo(2, "Edgar", 500000);
        System.out.println(cb);
        //downcasting
        //indirecto
        CuentaPlazoFijo cpf = (CuentaPlazoFijo)cb;
        cpf.setPlazoFin("30/11/2017");
        System.out.println("Intereses " + cpf.getIntereses());
        System.out.println(cb);
        //directo
        ((CuentaPlazoFijo)cb).setPlazoFin("11/12/2018");
         System.out.println(cb);
    }
}
