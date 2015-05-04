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
public class CuentaBancaria {
    protected int numero;
    protected String cliente;
    protected double saldo, tasa;
    protected Date fecha;

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTasa() {
        return tasa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }
    
    public void depositar(double m){
        saldo += m;
    }
    
    public boolean retirar(double m){
        if(saldo > m){
            saldo -= m;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + "numero=" + numero + ", cliente=" + cliente + ", saldo=" + saldo + '}';
    }
    
    
}
