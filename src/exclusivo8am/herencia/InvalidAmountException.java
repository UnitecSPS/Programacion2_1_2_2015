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
public class InvalidAmountException extends RuntimeException{
    public InvalidAmountException(double m){
        super("Amount Lps."+ m+" is invalid.");
    }
}
