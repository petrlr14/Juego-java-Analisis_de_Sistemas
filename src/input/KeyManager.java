/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Pedro Gómez
 */
public class KeyManager implements KeyListener{

    private boolean[] keys;
    public boolean down, left, right, up, space;
    
    public KeyManager(){
        keys=new boolean[256];
    }
    
    public void update(){
        up=keys[KeyEvent.VK_UP];
        down=keys[KeyEvent.VK_DOWN];
        left=keys[KeyEvent.VK_LEFT];
        right=keys[KeyEvent.VK_RIGHT];
        space=keys[KeyEvent.VK_SPACE];
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
        System.out.println("PRESSED");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    
}


