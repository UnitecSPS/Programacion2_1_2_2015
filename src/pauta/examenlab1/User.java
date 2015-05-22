/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pauta.examenlab1;

/**
 *
 * @author mac
 */
public class User {
    protected String email, nombre;

    public User(String email, String nombre) {
        this.email = email;
        this.nombre = nombre;
    }

    public final String getEmail() {
        return email;
    }

    public final String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", nombre=" + nombre + '}';
    }
    
    
}
