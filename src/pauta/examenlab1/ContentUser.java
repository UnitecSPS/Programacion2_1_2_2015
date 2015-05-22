/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pauta.examenlab1;

import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class ContentUser extends User implements Posteable {
    
    private ArrayList<Integer> postIds;

    public ContentUser(String email, String nombre) {
        super(email, nombre);
        postIds = new ArrayList<>();
    }

    @Override
    public void addPostId(int id) {
        if(!postIds.contains(id))
            postIds.add(id);
    }

    @Override
    public boolean accesoAPost(int id) {
        return postIds.contains(id);
    }

    @Override
    public String toString() {
        return super.toString() + "-ContentUser";
    }
    
    
    
}
