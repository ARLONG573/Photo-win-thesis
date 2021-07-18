package game.state;

import java.util.List;

import api.GameState;

/**
 * @author Aaron Tetens
 */
public class PhotosynthesisState implements GameState {

	public PhotosynthesisState(final PlayerInfo[] playerInfo) {

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
