package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JApplet;

@SuppressWarnings("serial")
public class Center extends JApplet implements MouseListener, MouseMotionListener {

	public static int NUMBER_OF_BANDS = 5;
    public Game shame = new Game();

    
    public Center(){
    	addMouseListener(this);
		addMouseMotionListener(this);
		setSize(800, 500);
		
    }
    
    public static Dimension getAppletSize(){
    	return new Dimension(800, 500);
    }
    
	public static void main(String[] args){
		
		
		
	}	

	public void update(){
		shame.update();
	}

	public void paintBackground(Graphics g){
		Dimension d = getSize();
		g.setColor(Color.RED);
		g.fillRect(0, 0, d.width, d.height);
		g.setColor(Color.black);
		Font font = new Font("Arial", Font.BOLD, 32);
		g.setFont(font);
	}

	
	public void paint(Graphics g){
		
		paintBackground(g);
		update();
		shame.paint(g);
		
	
	} 
	
	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {
	
		shame.mouseClicked(e);
		repaint();
		e.consume();

	}

	public void mousePressed(MouseEvent e) {
	 	
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mouseMoved (MouseEvent e){
				shame.mouseMoved(e);
	}

}
