package game.state;

/**
 * This class holds the unique info needed to initialize a player.
 * 
 * @author Aaron Tetens
 */
public class PlayerInfo {

	private final String name;
	private final TreeColor treeColor;
	private final boolean isAI;

	public PlayerInfo(final String name, final TreeColor treeColor, final boolean isAI) {
		this.name = name;
		this.treeColor = treeColor;
		this.isAI = isAI;
	}

	public String getName() {
		return this.name;
	}

	public TreeColor getTreeColor() {
		return this.treeColor;
	}

	public boolean isAI() {
		return this.isAI;
	}
}
