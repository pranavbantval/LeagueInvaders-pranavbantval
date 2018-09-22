import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
//member variables
	Integer speed;
	//constructor
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}
//methods
	void update() {
		
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);	
	}
}
