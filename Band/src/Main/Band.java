package Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import javax.imageio.ImageIO;

public class Band{

	private static final int IMG_WIDTH = 552;
	private static final int IMG_HEIGHT = 460;

	public int ID;
	public int bandID;
	public String name;
	public BufferedImage rawPic;
	public BufferedImage pic;
	private int s1, s2;
	public boolean squaresOn;

	public Band(int num){
		ID = num;
		squaresOn = true;
		String path = "/Band_(" + num + ").jpg";
		System.out.println(path);
		init();
		try{
			pic = ImageIO.read(getClass().getResourceAsStream(path));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void restart(int num){
		ID = num;
		squaresOn = true;
		String path = "/Band_(" + num + ").jpg";
		System.out.println(path);
		init();
		try{
			pic = ImageIO.read(getClass().getResourceAsStream(path));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void init(){
		Random r = new Random();
		int choice = r.nextInt(3);
		switch(choice){
		case 0:
			
			s1 = 0;
			s2 = 1;
			break;
		case 1:
			
			s1 = 0;
			s2 = 2;
			break;
		case 2:
			
			s1 = 1;
			s2 = 2;
			break;
		}
	}
	
	public void squares(Graphics g){//makes three square that cover up three fourths of the picture
		g.setColor(Color.gray);
		if(squaresOn){
		g.fillRect(100, 100, 552, 230);
		
		bottomSquares(s1, s2, g);
		}
	}
	
	public void bottomSquares(int a, int b, Graphics g){
		if(a == 0 || b == 0){
			g.fillRect(100, 330, 184, 230);
		}
		if(a == 1 || b == 1){
			g.fillRect(284, 330, 184, 230);
		}
		if(a == 2 || b == 2){
			g.fillRect(468, 330, 184, 230);
		}
	}
	
	public void draw(Graphics g){
		g.drawImage(pic, 100, 100, IMG_WIDTH, IMG_HEIGHT, null);
		
		squares(g);
	}
	
	public int getID(){
		return ID;
	}
	
	public void answered(){
		squaresOn = false;
	}
	
	public boolean getSquaresOn(){
		return squaresOn;
	}
	
	public String getName(){
		String name = "";
		try {
			
			InputStream in = getClass().getResourceAsStream("/Bands.txt");
			BufferedReader br = new BufferedReader(
						new InputStreamReader(in)
					);

			for(int i = 0; i < Center.NUMBER_OF_BANDS; i++){
				String tempName = br.readLine();
				if((ID >= (i * 5) + 1) && (i < (i * 5) + 6)){
					name = tempName;
					bandID = i;
				}
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(name);
		return name;
		
	}
	
	public String getGoodName(){
		String name = "";
		try {
			
			InputStream in = getClass().getResourceAsStream("/RealBands.txt");
			BufferedReader br = new BufferedReader(
						new InputStreamReader(in)
					);

			for(int i = 0; i < Center.NUMBER_OF_BANDS; i++){
				String tempName = br.readLine();
				if((ID >= (i * 5) + 1) && (i < (i * 5) + 6)){
					name = tempName;
					bandID = i;
				}
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(name);
		return name;
		
	}
	
	public int getBandID(){
		return bandID;
	}
	
}
	


