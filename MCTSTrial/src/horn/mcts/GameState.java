package horn.mcts;

public class GameState
{
    public int currentPlayer = -1;
    public int[][] currentBoard = new int[7][6];
    
    public GameState copy()
    {
        GameState newState = new GameState();
        newState.currentPlayer = this.currentPlayer;
        newState.currentBoard = this.currentBoard;
        return newState;
    }
}
