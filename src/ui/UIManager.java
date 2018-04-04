/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import launcher.Handler;

/**
 *
 * @author Pedro Gómez
 */
public class UIManager {
    
    private Handler handler;
    private ArrayList<UIObject> objects;
    
    public UIManager(Handler handler){
        this.handler=handler;
        objects=new ArrayList<>();
    }
    
    public void update(){
        for(UIObject o:objects)
            o.update();
    }
    
    public void render(Graphics g){
        for(UIObject o:objects)
            o.render(g);        
    }
    
    public void onMouseMove(MouseEvent e){
        for(UIObject o:objects)
            o.onMouseMove(e);    
    }
    
    public void onMouseRelase(MouseEvent e){
        for(UIObject o:objects)
            o.onMouseRelase(e);        
    }
    
    public void addObject(UIObject o){
        objects.add(o);
    }
    
    public void removeObject(UIObject o){
        objects.remove(o);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }
    
    
        
    
}
