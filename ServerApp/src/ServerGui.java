import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ServerGui extends JFrame{	
	
	JPanel video;
	
	int timer=0;
	
	long currentMilli, prevSec = System.currentTimeMillis(), prevMilli = System.currentTimeMillis();
	long fps = 1000/40; //30fps
	long correction=0;
	
	public void refresh(){
		
		currentMilli=System.currentTimeMillis();
		
		if(currentMilli-prevMilli>=fps){
			System.out.println(currentMilli-prevMilli);
			video.repaint();	
			timer++;
			prevMilli=currentMilli;
			
		}
		if(currentMilli-prevSec>=1000){
//			System.out.println(currentMilli-prevSec);
			prevSec=currentMilli;
			timer=0;
			System.out.println("FPS: " + timer);
		}
		
	}
	
	ServerGui(){
		
		JPanel sideBar = new JPanel();
		sideBar.setMinimumSize(new Dimension(200, SharedResources.frameHeight*SharedResources.scale));
		sideBar.setMaximumSize(new Dimension(200, SharedResources.frameHeight*SharedResources.scale));
			
		JLabel id1 = new JLabel("Cam 1");
		JLabel id2 = new JLabel("Cam 2");
		JLabel id3 = new JLabel("Cam 3");

		Container status = new Container();
			
		status.add(id1);
		status.add(id2);
		status.add(id3);
			
			
		DefaultListModel formato = new DefaultListModel();
		formato.addElement(status);
		JList lista = new JList(formato);
			
		add(lista);
	

		video = new JPanel(){
			//metodo alterado 
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(SharedResources.frame, 0, 0, SharedResources.frameWidth*SharedResources.scale, SharedResources.frameHeight*SharedResources.scale, null);					
			}
		};
		

		video.setMaximumSize(SharedResources.frameDimensionScaled);
		video.setMinimumSize(SharedResources.frameDimensionScaled);
		
		setMaximumSize(new Dimension(SharedResources.frameWidth*SharedResources.scale+200, SharedResources.frameHeight*SharedResources.scale));
		setMinimumSize(new Dimension(SharedResources.frameWidth*SharedResources.scale+200, SharedResources.frameHeight*SharedResources.scale));
		
		setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		add(sideBar);
		add(video);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
}