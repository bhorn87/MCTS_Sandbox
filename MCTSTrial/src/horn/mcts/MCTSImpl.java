package horn.mcts;

public class MCTSImpl 
{
    private int secondsToComplete = 10;
    GameBoard board = null;

    public MCTSImpl(GameBoard b)
    {
        board = b.copy();
    }
}
