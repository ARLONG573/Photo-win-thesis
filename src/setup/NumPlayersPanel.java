package setup;

import javax.swing.JPanel;

import setup.listeners.NumPlayersChangedListener;

public class NumPlayersPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private NumPlayersChangedListener listener;

	public void setNumPlayersChangedListener(final NumPlayersChangedListener listener) {
		this.listener = listener;
	}

}
