package game.state;

import java.util.List;

import api.GameState;

/**
 * @author Aaron Tetens
 */
public class PhotosynthesisState implements GameState {

	private final Player[] players;

	private int lastPlayer;
	private int currentPlayer;

	public PhotosynthesisState(final PlayerInfo[] playerInfo) {
		this.players = new Player[playerInfo.length];
		for (int i = 0; i < this.players.length; i++) {
			this.players[i] = new Player(playerInfo[i]);
		}

		this.lastPlayer = -1;
		this.currentPlayer = 0;
	}

	@Override
	public int getLastPlayer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GameState> getNextStates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameState getRandomNextState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getWinningPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

}
