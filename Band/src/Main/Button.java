package Main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class Button {

	private int ID;
	private boolean correct;
	public BufferedImage pic;
	public Rectangle collision;
	public int x, y = 700;
	
	public Button(int ID, boolean correct){
		
		this.ID = ID;
		this.correct = correct;

		collision = new Rectangle(x, y, 200, 53);
		String picPath = "/Buttons/" + makeName() + "_Button.png";
		System.out.println(picPath);
		
		try{
			pic = ImageIO.read(getClass().getResourceAsStream(picPath));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	
	
	public void init(){
		
	}
	
	public void setPlace(int xa){
		if(xa != 0){
			x = 50 + (xa * 225);
		}else{
			x = 50;
		}
		collision = new Rectangle(x, y, 200, 53);
	}
	
	public String makeName(){
		String name = "";
		try{
			
			InputStream in = getClass().getResourceAsStream("/Bands.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			if(ID != 0){
				
			for(int i = 0; i < ID + 1; i++){
				name = br.readLine();	
			}
			}else{
				name = "GreenDay";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("fake band name is " + name);
		return name;
	}
	
	public void draw(Graphics g){
		g.drawImage(pic, x, y, 200, 53, null);
		//g.fillRect(x, y, 200, 53);
	}
	
	public void clicked(){
		if(correct){
			System.out.println("Correct Choice!!");
		}else{
			System.out.println("Wrong Choice!!");
		}
	}
	
	public Rectangle getCollider(){
		return collision;
	}
	
}
