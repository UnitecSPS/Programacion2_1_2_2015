/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.herencia;

/**
 *
 * @author Aula
 */
public class PaymentInvalidException extends RuntimeException {
    public PaymentInvalidException(double m){
        super("Lps "+m+" is an invalid payment.");
    }
}
