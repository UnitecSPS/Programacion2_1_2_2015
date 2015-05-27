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
    public static final int version=2;
    
    public CuentaBancaria(int n, String c, double s, double t){
        numero = n;
        cliente = c;
        saldo = s;
        tasa = t;
        fecha = new Date();
    }

    public final int getNumero() {
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
        final int t=2;
        if(m < 0){
            //throw objeto instanciado de una clase throwable
            throw new InvalidAmountException(m);
        }
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
        return "numero=" + numero + ", cliente=" + cliente + ", saldo=" + saldo;
    }
    
    public void quienSoy(){
        System.out.println("SOY PAPA");
    }
}
