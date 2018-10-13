
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	// member variables
	  public static BufferedImage alienImg;
      public static BufferedImage rocketImg;
      public static BufferedImage bulletImg;
      public static BufferedImage spaceImg;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	ObjectManager managerBob = new ObjectManager(rocket);
	Font titleFont = new Font("Comic Sans", Font.PLAIN, 48);
	Font subtitleFont = new Font("Comic Sans", Font.PLAIN, 25);

	// constructor
	public GamePanel() {

		timer = new Timer(1000 / 60, this);
		try {
            alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
            rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
            bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
            spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
    } catch (IOException e) {
            // TODO Auto-generated catch block
           e.printStackTrace();
    }
	}

	// methods
	void updateMenuState() {

	}

	void updateGameState() {
		managerBob.update();
		managerBob.manageEnemies();
		managerBob.purgeObjects();
		managerBob.checkCollision();
if (!managerBob.ship.isAlive) {
			currentState = END_STATE;
		}
	}

	void updateEndState() {
		
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 200);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to start", 120, 350);

	}

	void drawGameState(Graphics g) {
		 g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		managerBob.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 130, 200);
		g.setFont(subtitleFont);
		g.drawString("You killed " +managerBob.score+ " enemies", 130, 350);
		g.drawString("Press ENTER to restart", 110, 550);

	}

	void startGame() {
		timer.start();

	}

	@Override

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
			// System.out.println("draw gamestate");
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END_STATE) {
				currentState = MENU_STATE;
				managerBob.restart();
				
			} else {
				currentState++;
			}
			
		} 
		else {
			Rocketship rocket = managerBob.ship;
		
	 if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.x = rocket.x - rocket.speed;
		
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.x = rocket.x + rocket.speed;
		
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.y = rocket.y - rocket.speed;
		
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.y = rocket.y + rocket.speed;
	
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			managerBob.addProjectile(rocket.x + 20, rocket.y, 10, 10);
			
		}
		managerBob.update();}
		}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
