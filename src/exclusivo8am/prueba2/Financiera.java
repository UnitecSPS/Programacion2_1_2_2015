/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.prueba2;

/**
 *
 * @author Docente 17082011
 */
public class Financiera {
    public static void main(String[] args) {
        Prestamo p = new Prestamito(1,"Morata",8000);
        ((Prestamito)p).pay(50);
        System.out.println(p.getBalance());
    }
}
