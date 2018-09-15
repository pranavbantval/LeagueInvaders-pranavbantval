import java.awt.Graphics;

public class GameObject {
	//member variables
	int x;
	int y;
	int width;
	int height;
	//constructor
	public GameObject(int x, int y, int width, int height) {
		x=this.x;
		y=this.y;
		width=this.width;
		height=this.height;
	}
//methods
	void update() {
		x++;
		y++;
	}
	void draw(Graphics g) {
		g.fillRect(x, y, 100, 100);
	}
}
