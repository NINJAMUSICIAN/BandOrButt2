package Main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class RestartButton {

	public BufferedImage pic;
	public Rectangle collision;
	public int x = 275, y = 25;
	private boolean display = false;
	
	public RestartButton(){
		String picPath = "/Buttons/Restart.png";
		collision = new Rectangle(x, y, 200, 53);
		try{
			pic = ImageIO.read(getClass().getResourceAsStream(picPath));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g){
		if(display){
		g.drawImage(pic, x, y, 200, 53, null);
		}
	}
	
	public void setDisplay(boolean b){
		display = b;
	}
	public boolean getDisplay(){
		return display;
	}
	
	public Rectangle getCollider(){
		return collision;
	}
	
}
