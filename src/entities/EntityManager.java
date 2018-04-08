    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.cratures.Enemigo;
import entities.cratures.Player;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import launcher.Handler;

/**
 *
 * @author Pedro Gómez
 */
public class EntityManager {
    
    private Handler handler;
    private Player player;
    private Enemigo enemigo;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter=new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY()+a.getHeight()<b.getY()+b.getHeight()){
                return -1;
            }else{
                return 1;
            }
        }
    };
    
    public EntityManager(Handler handler, Player player){
        this.handler=handler;
        this.player=player;
        entities=new ArrayList<>();
        addEntity(player);
    }
    public void update(){
        for(int i=0; i<entities.size();i++){
            Entity e=entities.get(i);
            e.update();
        }
        entities.sort(renderSorter);
    }
    
    public void render(Graphics g){
        for(Entity e:entities){
            e.render(g); 
            //g.fillRect(e.getCollisionBounds(0f,0f).x,e.getCollisionBounds(0f,0f).y-500,e.getCollisionBounds(0f,0f).width,e.getCollisionBounds(0f,0f).height);
        }
    }

    public void addEntity(Entity e){
        entities.add(e);
    }
    
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
    
        
}
