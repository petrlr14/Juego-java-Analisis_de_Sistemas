/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import entities.cratures.Player;
import entities.statics.Tree;
import gfx.Assets;
import java.awt.Graphics;
import launcher.Game;
import launcher.Handler;
import worlds.World;

/**
 *
 * @author Pedro Gómez
 */
public class GameState extends States{
    private World world;
    
    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "src/res/worlds/1.txt");
        handler.setWorld(world);
    }

    @Override
    public void update() {
        world.update();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }
    
}
