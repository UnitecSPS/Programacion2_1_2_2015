/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.herencia;

import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class Prestamo {
    protected int numero;
    protected String deudor;
    protected double monto, balance, tasa;
    protected Date fecha;
    public static final int version = 1;

    public Prestamo(int numero, String deudor, double monto, double tasa) {
        this.numero = numero;
        this.deudor = deudor;
        this.monto = monto;
        this.tasa = tasa;
        balance = monto;
        fecha = new Date();
    }
    
    public final int getNumero() {
        return numero;
    }

    public final String getDeudor() {
        return deudor;
    }

    public double getMonto() {
        return monto;
    }

    public double getBalance() {
        return balance;
    }

    public double getTasa() {
        return tasa;
    }

    public Date getFecha() {
        return fecha;
    }
    
    public void abono(double m){
        if( m < 0 )
            throw new PaymentInvalidException(m);
        balance -= m;
    }

    @Override
    public String toString() {
        return "numero=" + numero + ", deudor=" + 
                deudor + ", monto=" + monto + ", balance=" + 
                balance + ", tasa=" + tasa;
    }
    
    public void quienSoy(){
        final int x=9;
        System.out.println("SOY EL PADRE");
    }
}
