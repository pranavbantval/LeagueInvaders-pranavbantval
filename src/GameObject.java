import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	//member variables
	boolean isAlive = true;
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox = new Rectangle();
	//constructor
	public GameObject(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
	}
//methods
	void update() {
	collisionBox.setBounds(x, y, width, height);	
	}
	void draw(Graphics g) {
	
	}
}
