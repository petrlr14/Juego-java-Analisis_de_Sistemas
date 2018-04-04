/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Pedro Gómez
 */
public class Display {
    
    private String title;
    private int width, height;
    private JFrame frame;
    private Canvas canvas;
    
    
    public Display(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;
        creatDisplay();
    }
    
    private void creatDisplay(){
        
        frame=new JFrame(this.title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();
        
    }
    
    public Canvas getCanvas(){
        return this.canvas;
    }
    
    public JFrame getFrame(){
        return this.frame;
    }
    
}
