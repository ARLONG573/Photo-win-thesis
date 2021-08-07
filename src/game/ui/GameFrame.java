package game.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import game.state.PhotosynthesisState;

/**
 * This frame displays the game state and provides an interface for inputting
 * moves.
 * 
 * @author Aaron Tetens
 */
public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private final PlayersPanel playersPanel;

	public GameFrame(final PhotosynthesisState initialState) {
		super("Photo-win-thesis");

		this.playersPanel = new PlayersPanel(initialState.getPlayers());

		super.setLayout(new BorderLayout());
		super.add(this.playersPanel, BorderLayout.NORTH);

		super.setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
