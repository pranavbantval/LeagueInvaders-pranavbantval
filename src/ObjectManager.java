import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
//member variables
	ArrayList bullets = new ArrayList<Projectile>();
	Rocketship ship;
	Projectile pew =new Projectile(0,0,0,0);
	//constructor
	public ObjectManager(Rocketship ship) {
		this.ship=ship;
	}
	//methods
	void update() {
		ship.update();
		pew.update();
	}
	void draw(Graphics g) {
		ship.draw(g);
		pew.draw(g);
	}
	void addProjectile() {
		bullets.add(new Projectile(0,0,0,0));
	}
}
