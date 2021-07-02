package setup.listeners;

/**
 * The setup frame uses this listener to receive a notification whenever the
 * number of players is changed so that it may update the UI.
 * 
 * @author Aaron Tetens
 */
public interface NumPlayersChangedListener {

	public void numPlayersChanged(final int numPlayers);
}
