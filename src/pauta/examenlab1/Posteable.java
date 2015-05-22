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
public interface Posteable {
    double VERSION = 0.3;
    void addPostId(int id);
    boolean accesoAPost(int id);
}
