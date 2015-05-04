/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.herencia;

import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class Cheque {
    public int numero;
    public String beneficiario;
    public double monto;
    public Date fecha;
    public boolean cambiado; 

    public Cheque(int numero, String beneficiario, double monto) {
        this.numero = numero;
        this.beneficiario = beneficiario;
        this.monto = monto;
        fecha = new Date();
        cambiado = true;
    }
    
    public void reboto(){
        cambiado = false;
    }
    
    
}
