/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import java.awt.Graphics;
import launcher.Game;
import launcher.Handler;

/**
 *
 * @author Pedro Gómez
 */
public abstract class States {
    
    public static States currentState=null;
    
    public static void setState(States state){
        currentState=state;
    }
    
    public static States getState(){
        return currentState;
    }
    
    
    protected Handler handler;
    public States(Handler handler){
        this.handler=handler;
    }
    
    public abstract void update();
    public abstract void render(Graphics g);
    
}
