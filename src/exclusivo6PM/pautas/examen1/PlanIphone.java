/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.pautas.examen1;

/**
 *
 * @author Docente 17082011
 */
public class PlanIphone extends Plan
{
    public static final double LATEST_VERSION = 8.1;
    
    public PlanIphone(int nu, String no, String correo){
        super(nu,no,correo);
    }
    
    @Override
    public double pagoMensual(int mins, int msgs){
        return 22+mins*0.4 + msgs*0.1;
    }
    
}
