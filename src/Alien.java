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
			g.setColor(Color.red);
			g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
			g.setColor(Color.YELLOW);
	        g.fillRect(x, y, width, height);	
		}
}
