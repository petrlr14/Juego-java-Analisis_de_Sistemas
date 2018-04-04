/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import launcher.Game;
import launcher.Handler;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIManager;

/**
 *
 * @author Pedro Gómez
 */
public class MenuState extends States{

    private UIManager uiManager;
    
    public MenuState(Handler handler){
        super(handler);
        uiManager=new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        uiManager.addObject(new UIImageButton( 475-116, 300-42, 116,42, Assets.UI_Buttons, new ClickListener() {
            @Override
            public void onCLick() {
                handler.getMouseManager().setUIManager(null);
                States.setState(handler.getGame().gameState);
            }
        }));
    }
    
    @Override
    public void update() {
        uiManager.update();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
    
}
