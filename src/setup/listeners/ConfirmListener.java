package setup.listeners;

/**
 * The setup frame uses this listener to receive a notification whenever the
 * confirm button is clicked so that it may verify the setup.
 * 
 * @author Aaron Tetens
 */
public interface ConfirmListener {

	public void confirmButtonPressed();
}
