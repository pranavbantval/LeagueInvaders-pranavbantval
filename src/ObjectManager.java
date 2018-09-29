import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
//member variables
	ArrayList<Projectile> bullets = new ArrayList<Projectile>();
	ArrayList<Alien> martians = new ArrayList<Alien>();
	Rocketship ship;
	long enemyTimer = 0;
	int enemySpawnTime =5000;
	
	//constructor
	public ObjectManager(Rocketship ship) {
		this.ship=ship;
		
	}
	//methods
	void update() {
		for (Alien martian : martians) {
		martian.update();
		}
		ship.update();
		for (Projectile bullet : bullets) {
			bullet.update();
		}
		}
		
		
	
	void draw(Graphics g) {
		for (int i = 0; i < bullets.size(); i++) {
		ship.draw(g);
		for (Projectile bullet : bullets) {
			bullet.draw(g);
		}
		
		}
		for (Alien martian : martians) {
			martian.draw(g);
			}
	}
	void addProjectile(int x, int y, int width, int height) {
		bullets.add(new Projectile(x,y,width,height));
	}
	void addAlien(int x, int y, int width, int height) {
		martians.add(new Alien(x,y,width,height));
	}
	public void manageEnemies() {
        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            martians.add(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

enemyTimer = System.currentTimeMillis();
    }
}
void purgeObjects() {
	
for (int i = 0; i < bullets.size(); i++) {
	if(!bullets.get(i).isAlive) {
		bullets.remove(i);
	}
	}
	for (int j = 0; j < martians.size(); j++) {
		if(!martians.get(j).isAlive) {
			martians.remove(j);
		}
}
	

}
void checkCollision() {
	for(Alien martian : martians){

        if(ship.collisionBox.intersects(martian.collisionBox)){

                ship.isAlive = false;

        }
	}
        for(Projectile bullet2 : bullets){
	for(Alien martian2 : martians) {
		if(bullet2.x==martian2.x&&bullet2.y==martian2.y) {
		bullet2.isAlive=false;
		}
	}
	
}
        	for(Alien martian2 : martians) {
        		for(Projectile bullet2 : bullets){
        		if(bullet2.x==martian2.x&&bullet2.y==martian2.y) {
        			martian2.isAlive=false;
        		}
        	}
        	
        }

}
}
