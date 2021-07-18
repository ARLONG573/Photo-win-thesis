package setup.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import setup.listeners.ConfirmListener;

/**
 * This panel notifies the setup frame when the confrim button is pressed so
 * that it may check for a valid configuration and begin the game.
 * 
 * @author Aaron Tetens
 */
class ConfirmPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private ConfirmListener listener;

	ConfirmPanel() {
		super.setLayout(new BorderLayout());

		final JButton confirmButton = new JButton("Confirm");
		confirmButton.setFont(new Font("Arial", Font.PLAIN, 24));
		confirmButton.addActionListener((e) -> this.listener.confirmButtonPressed());
		super.add(confirmButton, BorderLayout.EAST);
	}

	void setConfirmListener(final ConfirmListener listener) {
		this.listener = listener;
	}

}
