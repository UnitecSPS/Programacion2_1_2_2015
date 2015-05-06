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

    public Prestamo(int numero, String deudor, double monto, double tasa) {
        this.numero = numero;
        this.deudor = deudor;
        this.monto = monto;
        this.tasa = tasa;
        balance = monto;
        fecha = new Date();
    }
    
    public int getNumero() {
        return numero;
    }

    public String getDeudor() {
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
        balance -= m;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "numero=" + numero + ", deudor=" + deudor + ", monto=" + monto + ", balance=" + balance + ", tasa=" + tasa + '}';
    }
    
    
}
