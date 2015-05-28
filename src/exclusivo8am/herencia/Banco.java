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
public class Banco {
    public static void main(String[] args) {
        
        CuentaBancaria cb = new CuentaBancaria(1, "CArlos", 5000, 0.03);
        try{
            cb.depositar(1);
        }
        catch(InvalidAmountException e){
            System.out.println("Error: "+e.getMessage());
        }
       
    }
}
