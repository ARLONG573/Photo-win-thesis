package setup.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import game.ui.GameFrame;
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
		this.playerEntriesPanel.setNumPlayers(numPlayers);

		// changing the number of players changes the number of player entry panels in
		// the frame, so packing it will make it look nicer
		SwingUtilities.invokeLater(() -> {
			super.pack();
			super.repaint();
			super.revalidate();
		});
	}

	@Override
	public void confirmButtonPressed() {
		final List<String> errorMessages = this.playerEntriesPanel.validateEntries();

		// no errors, the configuration is valid
		if (errorMessages.isEmpty()) {
			// TODO send setup data to game frame
			new GameFrame().setVisible(true);
			super.dispose();
		}
		// we got some errors, display a message
		else {
			final StringBuilder sb = new StringBuilder();

			for (final String errorMessage : errorMessages) {
				sb.append(errorMessage);
				sb.append("\n");
			}

			JOptionPane.showMessageDialog(this, sb.toString());
		}
	}
}
