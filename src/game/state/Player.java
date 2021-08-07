package game.state;

import java.awt.Color;

/**
 * This class holds the information both for storing a player's data and
 * rendering a player to the screen.
 * 
 * @author Aaron Tetens
 */
public class Player {

	private final PlayerInfo info;

	public Player(final PlayerInfo playerInfo) {
		this.info = playerInfo;
	}

	public String getName() {
		final StringBuilder sb = new StringBuilder();
		sb.append(info.getName());

		if (info.isAI()) {
			sb.append(" (AI)");
		}

		return sb.toString();
	}

	public Color getRenderColor() {
		return this.info.getTreeColor().getRenderColor();
	}

	public int getVP() {
		// TODO
		return 0;
	}

	public int getLP() {
		// TODO
		return 0;
	}

}
