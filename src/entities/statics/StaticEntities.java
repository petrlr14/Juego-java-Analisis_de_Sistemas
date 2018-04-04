    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.statics;

import entities.Entity;
import launcher.Handler;

/**
 *
 * @author Pedro Gómez
 */
public abstract class StaticEntities extends Entity {
    
    public StaticEntities(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }
    
}
