package setup;

import javax.swing.JPanel;

import setup.listeners.ConfirmListener;

/**
 * This panel notifies the setup frame when the confrim button is pressed so
 * that it may check for a valid configuration and begin the game.
 * 
 * @author Aaron Tetens
 */
public class ConfirmPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private ConfirmListener listener;

	public void setConfirmListener(final ConfirmListener listener) {
		this.listener = listener;
	}

}
