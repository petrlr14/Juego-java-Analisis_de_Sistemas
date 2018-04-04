 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author Pedro Gómez
 */
public class Assets {
    
    public static final int WIDTH=46, HEIGHT=49, HEIGHT2=48;
    public static final int wTile=32, hTile=32;
    public static BufferedImage[] player_DOWN, player_LEFT, player_RIGHT, player_UP,UI_Buttons, enemigoA;
    public static BufferedImage grass1, grass2, grass3, grass4, block1,block2, arbol;
    
    public static void init(){
        SpriteSheet personajeS=new SpriteSheet(ImageLoader.loadImage("/res/textures/Pert.png"));
        SpriteSheet enemigo=new SpriteSheet(ImageLoader.loadImage("/res/textures/BOSS.png"));
        SpriteSheet tilePaloma =new SpriteSheet(ImageLoader.loadImage("/res/tiles/mapaVergon.png"));
        SpriteSheet arboll=new SpriteSheet(ImageLoader.loadImage("/res/statics/Arbol2.png"));

        SpriteSheet botonNombal=new SpriteSheet(ImageLoader.loadImage("/res/ui/NOMAL.png"));
        SpriteSheet botonSobre=new SpriteSheet(ImageLoader.loadImage("/res/ui/SOBRE.png"));
        
        
        enemigoA=new BufferedImage[8];
        
        UI_Buttons=new BufferedImage[2];
        UI_Buttons[0]=botonNombal.crop(0, 0, 116, 42);
        UI_Buttons[1]=botonSobre.crop(0, 0, 116, 42);        
        
        
        arbol=arboll.crop(0, 0, 64, 64);
        
        
        
        grass1=tilePaloma.crop(wTile*0, hTile*0, wTile, hTile);
        grass2=tilePaloma.crop(wTile*1, hTile*0, wTile, hTile);
        grass3=tilePaloma.crop(wTile*2, hTile*0, wTile, hTile);
        grass4=tilePaloma.crop(wTile*3, hTile*0, wTile, hTile);
        
        block1=tilePaloma.crop(wTile*4, hTile*0, wTile, hTile);
        block2=tilePaloma.crop(wTile*5, hTile*0, wTile, hTile);
        
        
        player_DOWN=new BufferedImage[4];
        player_LEFT=new BufferedImage[4];
        player_RIGHT=new BufferedImage[4];
        player_UP=new BufferedImage[4];
        
        player_DOWN[0]=personajeS.crop(WIDTH*0, HEIGHT*0, WIDTH, HEIGHT2);
        player_DOWN[1]=personajeS.crop(WIDTH*1, HEIGHT*0, WIDTH, HEIGHT2);
        player_DOWN[2]=personajeS.crop(WIDTH*2, HEIGHT*0, WIDTH, HEIGHT2);
        player_DOWN[3]=personajeS.crop(WIDTH*1, HEIGHT*0, WIDTH, HEIGHT2);

        player_LEFT[0]=personajeS.crop(WIDTH*0, HEIGHT*1, WIDTH, HEIGHT2);
        player_LEFT[1]=personajeS.crop(WIDTH*1, HEIGHT*1, WIDTH, HEIGHT2);
        player_LEFT[2]=personajeS.crop(WIDTH*2, HEIGHT*1, WIDTH, HEIGHT2);
        player_LEFT[3]=personajeS.crop(WIDTH*1, HEIGHT*1, WIDTH, HEIGHT2);
        
        player_RIGHT[0]=personajeS.crop(WIDTH*0, HEIGHT*2, WIDTH, HEIGHT2);
        player_RIGHT[1]=personajeS.crop(WIDTH*1, HEIGHT*2, WIDTH, HEIGHT2);
        player_RIGHT[2]=personajeS.crop(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT2);
        player_RIGHT[3]=personajeS.crop(WIDTH*1, HEIGHT*2, WIDTH, HEIGHT2);
        
        player_UP[0]=personajeS.crop(WIDTH*0, HEIGHT*3, WIDTH, HEIGHT2);
        player_UP[1]=personajeS.crop(WIDTH*1, HEIGHT*3, WIDTH, HEIGHT2);
        player_UP[2]=personajeS.crop(WIDTH*2, HEIGHT*3, WIDTH, HEIGHT2);
        player_UP[3]=personajeS.crop(WIDTH*1, HEIGHT*3, WIDTH, HEIGHT2);
        
        enemigoA[0]=enemigo.crop(240*0, 193*0, 240, 194);
        enemigoA[1]=enemigo.crop(242*1, 193*0, 240, 194);
        enemigoA[2]=enemigo.crop(242*2, 193*0, 240, 194);
        enemigoA[3]=enemigo.crop(240*3, 193*0, 240, 194);
        enemigoA[4]=enemigo.crop(240*0, 193*1, 240, 194);
        enemigoA[5]=enemigo.crop(240*1, 193*1, 240, 194);
        enemigoA[6]=enemigo.crop(240*2, 193*1, 240, 194);
        enemigoA[7]=enemigo.crop(240*3, 193*1, 240, 194);
    }
    
}
