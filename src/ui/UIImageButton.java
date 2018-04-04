/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Pedro Gómez
 */
public class UIImageButton extends UIObject{

    private BufferedImage[] images;
    private ClickListener clicker;
    
    public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
        super(x, y, width, height);
        this.images=images;
        this.clicker=clicker;
    }

    @Override
    public void update() {}

    @Override
    public void render(Graphics g) {
        if(hovering){
            g.drawImage(Assets.UI_Buttons[1], (int)x, (int)y,width, height, null);
        }else{
            g.drawImage(Assets.UI_Buttons[0], (int)x, (int)y,width, height, null);
        }
    }

    @Override
    public void onClick() {
        clicker.onCLick();
    }
    
}
