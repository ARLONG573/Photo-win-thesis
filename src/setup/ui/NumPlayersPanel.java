package setup.ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import setup.listeners.NumPlayersChangedListener;

/**
 * This panel notifies the setup frame whenever the number of players is changed
 * so that the player entries panel may be updated.
 * 
 * @author Aaron Tetens
 */
public class NumPlayersPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private NumPlayersChangedListener listener;

	public NumPlayersPanel() {
		final JLabel numPlayersLabel = new JLabel("Number of players: ");
		numPlayersLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		super.add(numPlayersLabel);

		super.add(new NumPlayersButton(2));
		super.add(new NumPlayersButton(3));
		super.add(new NumPlayersButton(4));
	}

	public void setNumPlayersChangedListener(final NumPlayersChangedListener listener) {
		this.listener = listener;
	}

	private class NumPlayersButton extends JButton {

		private static final long serialVersionUID = 1L;

		private NumPlayersButton(final int number) {
			super(String.valueOf(number));
			super.setFont(new Font("Arial", Font.PLAIN, 24));
			super.addActionListener((e) -> NumPlayersPanel.this.listener.numPlayersChanged(number));
		}
	}
}
