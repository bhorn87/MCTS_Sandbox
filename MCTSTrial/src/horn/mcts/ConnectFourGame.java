package horn.mcts;

import java.util.ArrayList;
import java.util.List;

public class ConnectFourGame implements GameBoard
{
    private List<GameState> stateHistory = new ArrayList<GameState>();
    Player p1 = new Player("Player1");
    Player p2 = new Player("Player2");
    @Override
    public void initialize()
    {
        GameState initialState = new GameState();
        initialState.currentPlayer = 1;
        stateHistory.add(initialState);
    }

    @Override
    public Player getCurrentPlayer()
    {
        if (stateHistory != null && !stateHistory.isEmpty())
        {
            int curr = stateHistory.get(stateHistory.size() - 1).currentPlayer;
            if (curr == 1)
                return p1;
            if (curr == 2)
                return p2;
            return null;
        }
        return null;
    }

    @Override
    public GameState getNextGameState()
    {
        return null;
    }

    @Override
    public List<Integer> getLegalMoves()
    {
        List<Integer> legalMoves = new ArrayList<Integer>();
        if (stateHistory != null && !stateHistory.isEmpty())
        {
            GameState currentState = stateHistory.get(stateHistory.size() - 1);
            for (int movelocations = 0; movelocations < 7; movelocations++)
            {
                if (currentState.currentBoard[movelocations][5] == 0)
                {
                    legalMoves.add(movelocations);
                }
            }
        }
        return legalMoves;
    }

    @Override
    public int winner()
    {
        // TODO Auto-generated method stub
        return 0;
    }
}
