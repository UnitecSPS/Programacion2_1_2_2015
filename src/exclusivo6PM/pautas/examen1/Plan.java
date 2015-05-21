/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.pautas.examen1;

import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public abstract class Plan {
    protected int numero;
    protected String nombre, id;
    protected Date fecha;
    
    public Plan(int nu, String no, String i){
        numero =nu;
        nombre = no;
        id = i;
        fecha = new Date();
    }
    
    public int getNumero(){
        return numero;
    }
    
    public String getId(){
        return id;
    }
    
    abstract double pagoMensual(int mins, int msgs);
    
    public void imprimir(){
        System.out.println(numero+nombre+id+fecha);
    }
}
