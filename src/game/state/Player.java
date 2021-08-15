package game.state;

import java.awt.Color;
import java.util.Map;

/**
 * This class holds the information both for storing a player's data and
 * rendering a player to the screen.
 * 
 * @author Aaron Tetens
 */
public class Player {

	private final PlayerInfo info;

	private int vp; // victory points
	private int lp; // light points

	public Player(final PlayerInfo playerInfo) {
		this.info = playerInfo;

		this.vp = 0;
		this.lp = 0;
	}

	public Color getRenderColor() {
		return this.info.getTreeColor().getRenderColor();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();

		sb.append(this.getName());
		sb.append("\n");
		sb.append("Victory points: " + this.vp);
		sb.append("\n");
		sb.append("Light points: " + this.lp);

		return sb.toString();
	}

	private String getName() {
		final StringBuilder sb = new StringBuilder();
		sb.append(info.getName());

		if (info.isAI()) {
			sb.append(" (AI)");
		}

		return sb.toString();
	}
}
