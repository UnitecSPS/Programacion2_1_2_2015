/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.pautas.examen2;

/**
 *
 * @author Aula
 */
public class BlogUser {
    public String username, name;

    public BlogUser(String username, String name) {
        this.username = username;
        this.name = name;
    }

    @Override
    public String toString() {
        return name+"("+username+")";
    }
    
    
}
