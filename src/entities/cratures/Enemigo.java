/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.cratures;

import entities.Entity;
import gfx.Animation;
import gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import launcher.Handler;

/**
 *
 * @author Pedro Gómez
 */
public class Enemigo extends Creature{
    private BufferedImage curPosition;
    private Animation animation;
    
    public Enemigo(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        //bounds.x=17;
        //bounds.y=32;
        //bounds.width=16;
        //bounds.height=16;
        animation=new Animation(70, Assets.enemigoA);
        setBounds(width/2-25, height/2-25,50,50);
        setCenter(width/2-25, height/2-25);
    }

    @Override
    public void update() {
        animation.update();
        handler.getGameCamera().centerOnEntity(this);
        if(this.getCenterX()-handler.getWorld().getEntityManager().getPlayer().getX()<0){
            this.setxMove(1f);
        }else{
            this.setxMove(-1f);
        }
        if(this.getCenterY()-handler.getWorld().getEntityManager().getPlayer().getY()<0){
            this.setyMove(1f);
        }else{
            this.setyMove(-1f);
        }
        move();
    }
    
    

    @Override
    public void render(Graphics g) {
        g.drawImage(animation.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffSet()), (int)(y-handler.getGameCamera().getyOffSet()),width, height, null);
      //  g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffSet()), (int)(y+bounds.y-handler.getGameCamera().getyOffSet()), bounds.width, bounds.height);
    }
}
