/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Docente 17082011
 */
public enum TipoCuenta {
    AHORRO(0.03), CHEQUES(0), PLAZO(0.1), PLANILLA(0.01);
    double rate;
    
    private TipoCuenta(double r){
        rate = r;
    }
}
