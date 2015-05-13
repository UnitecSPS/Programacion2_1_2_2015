/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.io.Serializable;

/**
 *
 * @author Docente 17082011
 */
public interface InterZombiable extends Interneteable, Zombiable, Serializable {
    void mixin();
}
