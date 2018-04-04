/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import gfx.Assets;

/**
 *
 * @author Pedro Gómez
 */
public class Block2 extends Tile{
    
    public Block2(int id){
        super(Assets.block2,id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
