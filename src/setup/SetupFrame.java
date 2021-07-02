package setup;

import javax.swing.JFrame;

/**
 * This frame holds all of the UI components necessary to setup the game.
 * Setting up the game is comprised of selecting the number of players, giving
 * each player a name, giving each player a color, and selecting the player that
 * will be controlled by the AI.
 * 
 * @author Aaron Tetens
 */
public class SetupFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public SetupFrame() {
		super("Player Setup");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLocationRelativeTo(null); // put the frame in the center of the screen
	}
}
