
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Docente 17082011
 */
public class Fechas {
    public static void main(String[] args) {
        Date fecha = new Date();//fecha actual
        Date old = new Date(1);//fecha costumizable
        System.out.println(fecha);
        System.out.println(fecha+"Mili: "+ fecha.getTime());
        System.out.println(old);
        if(fecha.getTime() > old.getTime()){
            long diff = fecha.getTime() - old.getTime();
            double seg = diff/1000;
            double min = seg/60;
            double ho = min/60;
            double di = ho/24;
            double meses = di/30;
            double years = meses/12;
            System.out.println("Ha pasado: " + years);
        }
        
        if(fecha.after(old))
            System.out.println("Fecha paso despues de old");
        
        if(old.before(fecha))
            System.out.println("old paso despues de fecha");
        System.out.println(fecha.compareTo(old));
        
        Calendar c = Calendar.getInstance();
        c.set(1997,Calendar.JANUARY,20 );
        System.out.println(c.getTime());
        
        c.add(Calendar.YEAR, 2);
        c.add(Calendar.MONTH, -2);
        System.out.println(c.getTime());
        
        String name = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.forLanguageTag("es"));
    }
    
}
