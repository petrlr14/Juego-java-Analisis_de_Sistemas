/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.swing.plaf.basic.BasicTextUI;

/**
 *
 * @author Pedro Gómez
 */
public abstract class UIObject {
    
    protected float x, y;
    protected int width, height;
    protected boolean hovering=false;
    protected Rectangle bounds;
    
    public UIObject(float x, float y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        bounds=new Rectangle((int)x, (int)y, width, height);
    }
    
    public abstract void update();
    public abstract void render(Graphics g);
    public abstract void onClick();
    
    public void onMouseMove(MouseEvent e){
        if(bounds.contains(e.getX(), e.getY()))
            hovering=true;
        else
            hovering=false;
    }
    
    public void onMouseRelase(MouseEvent e){
        if(hovering && e.getButton()==MouseEvent.BUTTON1)
            onClick();
            
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isHovering() {
        return hovering;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }
    
    
}
