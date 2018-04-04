/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.cratures;

import gfx.Animation;
import gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import launcher.Game;
import launcher.Handler;

/**
 *
 * @author Pedro Gómez
 */
public class Player extends Creature {

    private Animation animDown, animUp, animLeft, animRight;
    private BufferedImage curPosition;
            
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x=17;
        bounds.y=32;
        bounds.width=16;
        bounds.height=16;
        animUp=new Animation(135, Assets.player_UP);
        animDown=new Animation(135, Assets.player_DOWN);
        animLeft=new Animation(135, Assets.player_LEFT);
        animRight=new Animation(135, Assets.player_RIGHT);
        curPosition = Assets.player_DOWN[1];
    }

    @Override
    public void update() {
        animDown.update();
        animLeft.update();
        animRight.update();
        animUp.update();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }
    
    public void getInput(){
        xMove=0;
        yMove=0;
        if(handler.getKeyManager().up)
            yMove=-speed;
        if(handler.getKeyManager().down)
            yMove=speed;
        if(handler.getKeyManager().right)
            xMove=speed;
        if(handler.getKeyManager().left)
            xMove=-speed;
        if(handler.getKeyManager().space)
            setSpeed(5.0f);
        if(!handler.getKeyManager().space)
            setSpeed(3.0f);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)(x-handler.getGameCamera().getxOffSet()), (int)(y-handler.getGameCamera().getyOffSet()),width, height, null);
      //  g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffSet()), (int)(y+bounds.y-handler.getGameCamera().getyOffSet()), bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove<0){
            curPosition=Assets.player_LEFT[1];
            return animLeft.getCurrentFrame();
        }else if(xMove>0){
            curPosition=Assets.player_RIGHT[1];
            return animRight.getCurrentFrame();
        }else if(yMove<0){
            curPosition=Assets.player_UP[1];
            return animUp.getCurrentFrame();
        }else if(yMove>0){
            curPosition=Assets.player_DOWN[1];
            return animDown.getCurrentFrame();
        }else{
            return curPosition;
        }
    }
    
}

 