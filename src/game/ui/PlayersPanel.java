package game.ui;

import java.awt.Font;
import java.awt.Graphics;

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

	PlayersPanel(final Player[] players) {
		for (final Player player : players) {
			super.add(new PlayerPanel(player));
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
			this.textArea.setBackground(this.player.getRenderColor());
			this.textArea.setEnabled(false);
			super.add(this.textArea);
		}

		@Override
		protected void paintComponent(final Graphics g) {
			final StringBuilder sb = new StringBuilder();
			sb.append(this.player.getName());
			sb.append("\n");
			sb.append("Victory points: " + this.player.getVP());
			sb.append("\n");
			sb.append("Light points: " + this.player.getLP());

			this.textArea.setText(sb.toString());
		}
	}
}
