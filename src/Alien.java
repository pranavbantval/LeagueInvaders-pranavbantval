import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	
	
	//constructor
	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
	}
	//methods
		void update() {
			super.update();
			y++;
			if(y>800) {
				isAlive=false;
			}
		}
		void draw(Graphics g) {
			 g.drawImage(GamePanel.alienImg, x, y, width, height, null);
		}
}
