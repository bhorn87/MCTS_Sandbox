package horn.mcts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MCTSImpl 
{
    private long millisecondsToComplete = 10000;
    private int maxMoves = 5;
    private Random r = new Random();
    
    GameBoard board = null;
    List<GameState> states = new ArrayList<GameState>();

    public MCTSImpl(GameBoard b)
    {
        board = b.copy();
        this.maxMoves = 10;
    }
    
    public void getPlay()
    {
        long begin = System.currentTimeMillis();
        while (System.currentTimeMillis() - begin < millisecondsToComplete)
        {
            runSimulation();
        }
    }
    
    public void runSimulation()
    {
        List<GameState> statesCopy = new ArrayList<GameState>();
        for (GameState gs : states)
            statesCopy.add(gs.copy());
        GameState currentState = statesCopy.get(statesCopy.size() - 1);
        
        for (int t = 0; t < maxMoves; t++)
        {
            List<Integer> legalPlays = board.getLegalMoves(statesCopy);
            int play = legalPlays.get(r.nextInt(legalPlays.size()));
            
            GameState newState = board.getNextGameState(currentState, play);
            statesCopy.add(newState);
            
            Player winner = board.winner(statesCopy);
            if (winner != null)
                break;
        }
    }
}
