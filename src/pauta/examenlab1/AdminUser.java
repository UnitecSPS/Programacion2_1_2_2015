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
public class AdminUser extends User {

    public AdminUser(String email, String nombre) {
        super(email, nombre);
    }

    @Override
    public String toString() {
        return super.toString() + "Admin";
    }
    
    
    
}
