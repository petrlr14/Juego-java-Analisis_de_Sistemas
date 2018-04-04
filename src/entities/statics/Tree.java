/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.statics;

import gfx.Assets;
import java.awt.Graphics;
import javafx.geometry.Bounds;
import launcher.Handler;
import tiles.Tile;

/**
 *
 * @author Pedro Gómez
 */
public class Tree extends StaticEntities{

    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH*2, Tile.TILEHEIGHT*2);
        bounds.x=10;
        bounds.y=(int)(height/1.5f);
        bounds.width=width-20;
        bounds.height=(int)(height-height/1.5f);
    }
    
    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.arbol, (int)(x-handler.getGameCamera().getxOffSet()), (int)(y-handler.getGameCamera().getyOffSet()), width, height,null);
    }

    
    
}
