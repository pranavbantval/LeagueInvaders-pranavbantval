import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
//member variables
	Integer speed;

	//constructor
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 15;
	}
//methods
	void update() {
		super.update();
	
		
	}
	void draw(Graphics g) {
		 g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
		}
}
