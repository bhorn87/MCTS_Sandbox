package horn.mcts;

import java.util.List;

public interface GameBoard 
{
    public void initialize();
    public Player getCurrentPlayer(GameState g);
    public GameState getNextGameState(GameState g, int m);
    public List<Integer> getLegalMoves(List<GameState> history);
    public Player winner(List<GameState> history);
    public GameBoard copy();
}
