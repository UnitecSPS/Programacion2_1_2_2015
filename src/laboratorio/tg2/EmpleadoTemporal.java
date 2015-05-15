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
public class EmpleadoTemporal extends Empleado {
    private Calendar finContrato;
    
    public EmpleadoTemporal(int codigo, String nombre, double salario) {
        super(codigo, nombre, salario);
        finContrato = Calendar.getInstance();
    }

    public void setFinContrato(int y, int m, int d) {
        this.finContrato.set(y, m-1, d);
    }

    @Override
    double pago() {
        Calendar hoy = Calendar.getInstance();
        if(hoy.before(finContrato))
            return salario;
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " fin contrato: " + finContrato.getTime(); 
    }
    
    
    
}
