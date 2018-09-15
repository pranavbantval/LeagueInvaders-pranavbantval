import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	//member variables
	JFrame frame;
	GamePanel gamepanel;
	static final int WIDTH = 500;
	static final int HEIGHT = 800;
//constructor
	public LeagueInvaders() {
		frame = new JFrame();
		gamepanel = new GamePanel();
	}
//methods
	public void setup() {

		frame.add(gamepanel);

		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamepanel.startGame();
	}

	public static void main(String[] args) {
		LeagueInvaders league = new LeagueInvaders();
		league.createUI();
	}

	public void createUI() {
		setup();
		frame.addKeyListener(gamepanel);
	}
}
