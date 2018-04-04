/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;
import display.*;
/**
 *
 * @author Pedro Gómez
 */
public class Launcher {
    
    public static void main(String[] args) {
        Game game=new Game("oli",950,600);
        game.start();
    }
    
}
