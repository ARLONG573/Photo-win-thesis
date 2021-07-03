package setup;

import javax.swing.JPanel;

import setup.listeners.ConfirmListener;

public class ConfirmPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private ConfirmListener listener;

	public void setConfirmListener(final ConfirmListener listener) {
		this.listener = listener;
	}

}
