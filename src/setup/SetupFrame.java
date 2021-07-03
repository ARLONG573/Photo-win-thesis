package setup;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import setup.listeners.ConfirmListener;
import setup.listeners.NumPlayersChangedListener;

/**
 * This frame holds all of the UI components necessary to setup the game.
 * Setting up the game is comprised of selecting the number of players, giving
 * each player a name, giving each player a color, and selecting the player that
 * will be controlled by the AI.
 * 
 * @author Aaron Tetens
 */
public class SetupFrame extends JFrame implements ConfirmListener, NumPlayersChangedListener {

	private static final long serialVersionUID = 1L;

	private final NumPlayersPanel numPlayersPanel;
	private final PlayerEntriesPanel playerEntriesPanel;
	private final ConfirmPanel confirmPanel;

	public SetupFrame() {
		super("Player Setup");

		this.numPlayersPanel = new NumPlayersPanel();
		this.numPlayersPanel.setNumPlayersChangedListener(this);

		this.playerEntriesPanel = new PlayerEntriesPanel();

		this.confirmPanel = new ConfirmPanel();
		this.confirmPanel.setConfirmListener(this);

		super.setLayout(new BorderLayout());
		super.add(this.numPlayersPanel, BorderLayout.NORTH);
		super.add(this.playerEntriesPanel, BorderLayout.CENTER);
		super.add(this.confirmPanel, BorderLayout.SOUTH);
		super.pack();
		
		super.setLocationRelativeTo(null); // put the frame in the center of the screen
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void numPlayersChanged(final int numPlayers) {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirmButtonPressed() {
		// TODO Auto-generated method stub

	}
}
