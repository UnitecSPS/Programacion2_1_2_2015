/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laboratorio.tg2;

import java.util.Calendar;

/**
 *
 * @author Docente 17082011
 */
public class EmpleadoVenta extends Empleado implements Comisionable {
    private double ventas[]; 
    private final double tasaXVenta = 0.05;
            
    public EmpleadoVenta(int codigo, String nombre, double salario) {
        super(codigo, nombre, salario);
        ventas = new double[12];
    }
    
    private int getMesActual(){
        return Calendar.getInstance().get(Calendar.MONTH);
    } 
    
    void actualizarVenta(double m){
        ventas[getMesActual()] += m;
    }
    
     @Override
    public double comision() {
        return ventas[getMesActual()] * tasa();
    }

    @Override
    double pago() {
        return salario + comision();
    }

    @Override
    public double ventaAnual() {
        //double c = DoubleStream.of(ventas).sum();
        double v = 0;
        for(double ve : ventas)
            v+=ve;
        return v;
    }

    @Override
    public double tasa() {
        return tasaXVenta;
    }
    
}
