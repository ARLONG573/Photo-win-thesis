package setup;

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

	public void setNumPlayersChangedListener(final NumPlayersChangedListener listener) {
		this.listener = listener;
	}

}
