import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
//member variables
	int speed = 10;
	//constructor
	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	//methods
	void update() {
		y=y-speed;
		if(y<0) {
			isAlive=false;
		}
	}
	void draw(Graphics g){
		g.setColor(Color.RED);
        g.fillRect(x, y, width, height);	
	}
}
