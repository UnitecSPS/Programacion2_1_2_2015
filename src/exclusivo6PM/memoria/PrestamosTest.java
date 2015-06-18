/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.memoria;

/**
 *
 * @author Aula
 */
public class PrestamosTest {
    public static void main(String[] args) {
        ArrayListPrestamo list = new ArrayListPrestamo();
        
        list.add( new Prestamo("Alvaro", 5000));
        list.add( new Prestamo("Douglas",3000));
        list.add( new Prestamo("Alejandro", 6500));
        list.add( new Prestamo("Carlos", 2500));
        list.print();
    }
}
