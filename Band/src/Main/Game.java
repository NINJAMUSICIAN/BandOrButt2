package Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

public class Game implements MouseListener, MouseMotionListener{

	private Band band;
	private String bandName;
	private int bandChoice;
	private Button button, button2, button3;
	private RestartButton restart;
	private Rectangle mouseRec;
	private int mx, my;
	
	public int chosen = 0;
	private String correction;
	private String correctAnswer; //if wrong tells what correct band name is
	
	public Game(){
		init();
	}
	
	public void init(){
	startGame();
	mouseRec = new Rectangle(mx - 20, my - 20, 40, 40);
	}

	
	
	public void startGame(){
		correction = "";
		correctAnswer = "";
		Random r = new Random();
		bandChoice = r.nextInt(25) + 1;
		band = new Band(bandChoice);
		bandName = band.getName();
		System.out.println("correct band name is " + bandName);
		restart = new RestartButton();
		makeButtons();
		setButtonPositions();
	}
	
	public void makeButtons(){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Random r = new Random();
		while(numbers.size() < Center.NUMBER_OF_BANDS - 1){
			int random = r.nextInt(Center.NUMBER_OF_BANDS);
			
			if(!numbers.contains(random) && random != band.getBandID()){
					numbers.add(random);
			}
		}
		
		System.out.println(numbers.get(0) + " " + numbers.get(1) + " " + numbers.get(2));
		
		//correct button
		button = new Button(band.getBandID(), true);
		
		//incorrect
		button2 = new Button(numbers.get(1), false);
		button3 = new Button(numbers.get(2), false);
	}
	
	public void setButtonPositions(){
		ArrayList<Integer> places = new ArrayList<Integer>();
		Random r = new Random();
		
		while(places.size() < 3){
			int random = r.nextInt(3);
			if(!places.contains(random)){
				places.add(random);
			}
		}
		
		System.out.println(places.get(0) + " " + places.get(1) + " " + places.get(2));
		
		button.setPlace(places.get(0));
		button2.setPlace(places.get(1));
		button3.setPlace(places.get(2));
		
		
	}
	
	public void correct(){
		if(chosen == 0){
			System.out.println("Correct!");
			correction = "Correct";
			chosen++;
			band.answered();
			restart.setDisplay(true);
		}
	}

	public void incorrect(){
		if(chosen == 0){
			System.out.println("correct band name was " + band.getGoodName());
			correction = "Wrong";
			correctAnswer = "correct band name was: " + band.getGoodName();
			chosen++;
			band.answered();
			restart.setDisplay(true);
		}
	}
	
	public void update(){
		mouseRec = new Rectangle(mx - 20, my - 20, 40, 40);
		//Correct Button
		if(mouseRec.intersects(button.getCollider())){
			correct();
		}
		if(mouseRec.intersects(button2.getCollider())){
			incorrect();
		}
		if(mouseRec.intersects(button3.getCollider())){
			incorrect();
		}
		
		if(restart.getDisplay() && mouseRec.intersects(restart.getCollider())){
			restart();
		}
		
	}

	public void paint(Graphics g){
		g.setColor(Color.blue);
		g.setColor(Color.black);
		
		Font user = new Font("Arial", Font.BOLD, 69);
		g.setFont(user);
		drawCenteredStringHori(correction, Center.getAppletSize().width, 620 , g);
		Font user2 = new Font("Arial", Font.BOLD, 20);
		g.setFont(user2);
		drawCenteredStringHori(correctAnswer, Center.getAppletSize().width, 660, g);
		
		band.draw(g);
		button.draw(g);
		button2.draw(g);
		button3.draw(g);
		restart.draw(g);
		
	}

	 public void drawCenteredString(String s, int w, int h, Graphics g) {
		    FontMetrics fm = g.getFontMetrics();
		    int x = (w - fm.stringWidth(s)) / 2;
		    int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
		    g.drawString(s, x, y);
		  }
	
	 public void drawCenteredStringHori(String s, int w, int ya, Graphics g) {
		    FontMetrics fm = g.getFontMetrics();
		    int x = (w - fm.stringWidth(s)) / 2;
		    int y = ya;
		    g.drawString(s, x, y);
		  }
	 
	public void restart(){
		chosen = 0;
		correction = "";
		startGame();
	
		
	}
	
	public void mouseClicked(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		
		mouseRec = new Rectangle(mx - 20, my - 20, 40, 40);
	}

	
	public void mouseEntered(MouseEvent e) {
		
	}

	
	public void mouseExited(MouseEvent e) {
		
	}

	
	public void mousePressed(MouseEvent e) {
		
	}

	
	public void mouseReleased(MouseEvent e) {
		
	}

	
	public void mouseDragged(MouseEvent e) {
		
	}

	
	public void mouseMoved(MouseEvent e) {
		
	
	}
}
