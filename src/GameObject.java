import java.awt.Graphics;

public class GameObject {
	//member variables
	boolean isAlive = true;
	int x;
	int y;
	int width;
	int height;
	//constructor
	public GameObject(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
	}
//methods
	void update() {
		
	}
	void draw(Graphics g) {
	
	}
}
