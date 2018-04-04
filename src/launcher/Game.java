/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;

import display.Display;
import gfx.Assets;
import gfx.GameCamera;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import input.KeyManager;
import input.MouseManager;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import states.GameState;
import states.MenuState;
import states.States;

/**
 *
 * @author Pedro Gómez
 */
public class Game implements Runnable{
    
    private Display display;
    private int width, height;
    private String title;
    private boolean running=false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;
    
    //INPUTS
    private KeyManager km;
    private MouseManager mm;
    
    //CAMERA
    private GameCamera camera;
    
    //Handler
    private Handler handler;
    
    //States declaration
    public States gameState;
    public States menuState;
    
    public Game(String title, int width, int height){
        this.width=width;
        this.height=height;
        this.title=title;
        km=new KeyManager();
        mm=new MouseManager();
    }

    private void update(){
        km.update();
        if(States.getState()!=null){
            States.getState().update();
        }
    }
    private void render(){
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();
        //cleaning
        g.clearRect(0, 0, width, height);
        if(States.getState()!=null){
            States.getState().render(g);
        }
        bs.show();
        g.dispose();
        
    }
    
    private void init(){
        display=new Display(title,width,height);
        Assets.init();
        
        
        
        handler=new Handler(this);
        camera=new GameCamera(handler, 0, 0);
        gameState=new GameState(handler);
        menuState=new MenuState(handler);
        States.setState(menuState);
        display.getFrame().addKeyListener(km);
        display.getFrame().addMouseListener(mm);
        display.getFrame().addMouseMotionListener(mm);
        display.getCanvas().addMouseListener(mm);
        display.getCanvas().addMouseMotionListener(mm);

    }
    
    @Override
    public void run() {
        init();
        
        int fps=60;
        double timePerUpdate=1000000000/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime() ;
        long timer=0;
        int updates=0;
        
        while(running){
            now=System.nanoTime();
            delta+=(now-lastTime)/timePerUpdate;
            timer+=now-lastTime;
            lastTime=now;
            
            if(delta>=1){
                update();
                render();
                updates++;
                delta--;
            }
            if(timer>=1000000000){
                System.out.println(updates);
                updates=0;
                timer=0;
            }
        }
        stop();
    }
    
    public KeyManager getKeyManager(){
        return km;
    }
    
    public MouseManager getMouseManager(){
        return mm;
    }
    
    public GameCamera getGameCamera(){
        return camera;
    }

    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }

     
    
    
    public synchronized void start(){
        if(running){
            return;
        }else{
            running=true;
            thread=new Thread(this);
            thread.start();
        }
    }
    
    public synchronized void stop(){
        if(!running){
            return; 
        }else{
            running=false;
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
}
