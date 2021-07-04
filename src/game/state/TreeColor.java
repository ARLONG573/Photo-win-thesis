package game.state;

import java.awt.Color;

/**
 * @author Aaron Tetens
 */
public enum TreeColor {

	ORANGE(Color.ORANGE, "Orange"), YELLOW(Color.YELLOW, "Yellow"), GREEN(Color.GREEN, "Green"), BLUE(Color.BLUE,
			"Blue");

	private final Color renderColor;
	private final String displayName;

	private TreeColor(final Color renderColor, final String displayName) {
		this.renderColor = renderColor;
		this.displayName = displayName;
	}

	public Color getRenderColor() {
		return this.renderColor;
	}

	@Override
	public String toString() {
		return this.displayName;
	}
}
