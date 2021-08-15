package game.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import game.state.Player;

/**
 * This panel displays the players' states during the game.
 * 
 * @author Aaron Tetens
 */
class PlayersPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final PlayerPanel[] playerPanels;

	PlayersPanel(final Player[] players) {
		this.playerPanels = new PlayerPanel[players.length];

		for (int i = 0; i < players.length; i++) {
			final Player player = players[i];
			final PlayerPanel playerPanel = new PlayerPanel(player);

			super.add(playerPanel);
			this.playerPanels[i] = playerPanel;
		}
	}

	/**
	 * The current player is shown by adding a black border around their panel.
	 * 
	 * @param index
	 *            The index of the player to show as the current player
	 */
	void setCurrentPlayer(final int index) {
		for (int i = 0; i < this.playerPanels.length; i++) {
			if (i == index) {
				this.playerPanels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			} else {
				this.playerPanels[i].setBorder(BorderFactory.createEmptyBorder());
			}
		}
	}

	private class PlayerPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		private final Player player;
		private final JTextArea textArea;

		private PlayerPanel(final Player player) {
			this.player = player;

			this.textArea = new JTextArea();
			this.textArea.setFont(new Font("Arial", Font.PLAIN, 24));
			this.textArea.setForeground(Color.BLACK);
			this.textArea.setBackground(this.player.getRenderColor());
			this.textArea.setEditable(false);
			super.add(this.textArea);
		}

		@Override
		protected void paintComponent(final Graphics g) {
			super.paintComponent(g);

			this.textArea.setText(this.player.toString());
		}
	}
}
