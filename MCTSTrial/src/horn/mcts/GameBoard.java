package horn.mcts;

import java.util.List;

public interface GameBoard 
{
    public void initialize();
    public Player getCurrentPlayer();
    public GameState getNextGameState();
    public List<?> getLegalMoves();
    public int winner();
}