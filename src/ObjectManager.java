import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	// member variables
	ArrayList<Projectile> bullets = new ArrayList<Projectile>();
	ArrayList<Alien> martians = new ArrayList<Alien>();
	Rocketship ship;
	long enemyTimer = 0;
	int enemySpawnTime = 5000;
int score = 0;
	// constructor
	public ObjectManager(Rocketship rocket) {
		this.ship = rocket;

	}

	// methods
	
	void update() {
		for (Alien martian : martians) {
			martian.update();
		}
		getScore();
		ship.update();
		for (Projectile bullet : bullets) {
			bullet.update();
		}
	}

	public int getScore() {
		return score;
	}



	void draw(Graphics g) {

		ship.draw(g);

		for (Projectile bullet : bullets) {
			bullet.draw(g);
		}

		for (Alien martian : martians) {
			martian.draw(g);
		}
	}

	void addProjectile(int x, int y, int width, int height) {
		bullets.add(new Projectile(x, y, width, height));
	}

	void addAlien(int x, int y, int width, int height) {
		martians.add(new Alien(x, y, width, height));
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			martians.add(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {

		for (int i = 0; i < bullets.size(); i++) {
			if (!bullets.get(i).isAlive) {
				bullets.remove(i);

			}
		}
		for (int j = 0; j < martians.size(); j++) {
			//System.out.println(martians.size());
			if (!(martians.get(j).isAlive)) {
				martians.remove(j);
				

			}
		}

	}

	void checkCollision() {
		for (Alien martian : martians) {
			if (ship.collisionBox.intersects(martian.collisionBox)) {
				System.out.println("ship dead");
				ship.isAlive = false;
			}

			for (Projectile bullet : bullets) {

				if (bullet.collisionBox.intersects(martian.collisionBox)) {
					bullet.isAlive = false;
					martian.isAlive = false;
					score++;
				//	System.out.println("dead");
				}
			}
		}

	}
}
