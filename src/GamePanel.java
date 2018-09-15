
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	//member variables
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
;
Font titleFont = new Font("Comic Sans", Font.PLAIN, 48);
Font subtitleFont = new Font("Comic Sans",Font.PLAIN,25);
//constructor
	public GamePanel() {

		timer = new Timer(1000 / 60, this);
	}
//methods
	void updateMenuState() {
		
	}
void updateGameState() {
		
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
	g.drawString("Press SPACE for instructions", 80, 550);
}
void drawGameState(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titleFont);
	g.setColor(Color.BLACK);
	g.drawString("Game Over", 130, 200);
	g.setFont(subtitleFont);
	g.drawString("You killed "+" enemies", 130, 350);
	g.drawString("Press ENTER to restart", 110, 550);
	
}
	void startGame() {
		timer.start();

	}

	@Override

	public void paintComponent(Graphics g) {

		 if(currentState == MENU_STATE){
			 drawMenuState(g);
     }else if(currentState == GAME_STATE){
    	 drawGameState(g);
     }else if(currentState == END_STATE){
             drawEndState(g);
     }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(currentState == MENU_STATE){
             updateMenuState();
     }else if(currentState == GAME_STATE){
             updateGameState();
     }else if(currentState == END_STATE){
             updateEndState();
     }repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
System.out.println("message1");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("message2");
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(currentState==END_STATE) {
			currentState=MENU_STATE;
			}
			else {
				currentState++;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("message3");
	}

}
