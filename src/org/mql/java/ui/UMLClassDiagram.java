package org.mql.java.ui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.mql.java.reflection.ClassParser;

public class UMLClassDiagram {
	 private JFrame frame;
	    private JPanel pane;
	   

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new UMLClassDiagram().createAndShowGui();
	            }
	        });
	    }

	    public void createAndShowGui() {
	        frame = new JFrame(getClass().getSimpleName());
	        pane = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g); 
                   
	                g.drawRect(20, 10, 100, 10);//la classe
	                g.drawRect(20, 20, 100, 30); //les attributs
	                g.drawRect(20, 50, 100, 40);//les methodes
	                
	                g.drawRect(140, 10, 100, 10);//la classe
	                g.drawRect(140, 20, 100, 30); //les attributs
	                g.drawRect(140, 50, 100, 40);//les methodes
	                g.dispose();
	            }

	            @Override
	            public Dimension getPreferredSize() {
	                return new Dimension(800, 800);
	            }
	        };
           
	        frame.add(pane);
	        frame.pack();
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	    }
}
