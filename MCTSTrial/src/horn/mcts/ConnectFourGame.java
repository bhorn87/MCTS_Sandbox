package horn.mcts;

import java.util.ArrayList;
import java.util.List;

public class ConnectFourGame implements GameBoard
{
    public int numColumns = 7;
    public int numRows = 6;
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
    public Player getCurrentPlayer(GameState g)
    {
//        if (stateHistory != null && !stateHistory.isEmpty())
//        {
//            int curr = stateHistory.get(stateHistory.size() - 1).currentPlayer;
//            if (curr == 1)
//                return p1;
//            if (curr == 2)
//                return p2;
//            return null;
//        }
    	int curr = g.currentPlayer;
		if (curr == 1)
			return p1;
		if (curr == 2)
			return p2;
		return null;
    }

    @Override
    public GameState getNextGameState(GameState currentState, int move)
    {
        return null;
    }

    @Override
    public List<Integer> getLegalMoves(List<GameState> history)
    {
        List<Integer> legalMoves = new ArrayList<Integer>();
        if (stateHistory != null && !stateHistory.isEmpty())
        {
            GameState currentState = stateHistory.get(stateHistory.size() - 1);
            for (int movelocations = 0; movelocations < numColumns; movelocations++)
            {
                if (currentState.currentBoard[movelocations][numRows-1] == 0)
                {
                    legalMoves.add(movelocations);
                }
            }
        }
        return legalMoves;
    }

    @Override
    public Player winner(List<GameState> history)
    {
    	// score[col1,..,col7,row1,...,row6,rightDia1,...,rightDia6,leftDia1,...,leftDia6]
        // Increase score for each entity to which a cell belongs.
        // Reset score if a non-contiguous piece is found. Winner if any reaches 4(-4).
        
        GameState last = history.get(history.size() -1);
    	int score[] = new int[25];
    	
    	for (int column = 0; column < numColumns; column++)
    	{
    	    for (int row = 0; row < numRows; row++)
    	    {
    	        if (last.currentBoard[column][row] == 1)
    	        {
    	            // update row score
    	            score[row] += 1;
    	            // update column score
    	            score[numColumns + column] += 1;
    	            // update right diagonal score
                    if (row-2 == column)
                        score[numColumns + numRows] += 1;
                    if (row-1 == column)
                        score[numColumns + numRows + 1] += 1;
                    if (row == column)
                        score[numColumns + numRows + 2] += 1;
                    if (row == column-1)
                        score[numColumns + numRows + 3] += 1;
                    if (row == column-2)
                        score[numColumns + numRows + 4] += 1;
    	            if (row == column-3)
    	                score[numColumns + numRows + 5] += 1;
    	            // update left diagonal score
                    if (row+2 == (numRows - 1 - column))
                        score[numColumns + numRows + 6] += 1;
                    if (row+1 == (numRows - 1 - column))
                        score[numColumns + numRows + 7] += 1;
                    if (row == (numRows - 1 - column))
                        score[numColumns + numRows + 8] += 1;
                    if (row == (numRows - column))
                        score[numColumns + numRows + 9] += 1;
                    if (row == (numRows - column + 1))
                        score[numColumns + numRows + 10] += 1;
                    if (row == (numRows - column + 2))
                        score[numColumns + numRows + 11] += 1;  
    	        }
    	        else if (last.currentBoard[column][row] == 2)
    	        {
                    // update row score
                    score[row] += 1;
                    // update column score
                    score[numColumns + column] -= 1;
                    // update right diagonal score
                    if (row-2 == column)
                        score[numColumns + numRows] -= 1;
                    if (row-1 == column)
                        score[numColumns + numRows + 1] -= 1;
                    if (row == column)
                        score[numColumns + numRows + 2] -= 1;
                    if (row == column-1)
                        score[numColumns + numRows + 3] -= 1;
                    if (row == column-2)
                        score[numColumns + numRows + 4] -= 1;
                    if (row == column-3)
                        score[numColumns + numRows + 5] -= 1;
                    // update left diagonal score
                    if (row+2 == (numRows - 1 - column))
                        score[numColumns + numRows + 6] -= 1;
                    if (row+1 == (numRows - 1 - column))
                        score[numColumns + numRows + 7] -= 1;
                    if (row == (numRows - 1 - column))
                        score[numColumns + numRows + 8] -= 1;
                    if (row == (numRows - column))
                        score[numColumns + numRows + 9] -= 1;
                    if (row == (numRows - column + 1))
                        score[numColumns + numRows + 10] -= 1;
                    if (row == (numRows - column + 2))
                        score[numColumns + numRows + 11] -= 1;
    	        }
    	        else
    	        {
                    // update row score
                    score[row] = 0;
                    // update column score
                    score[numColumns + column] = 0;
                    // update right diagonal score
                    if (row-2 == column)
                        score[numColumns + numRows] = 0;
                    if (row-1 == column)
                        score[numColumns + numRows + 1] = 0;
                    if (row == column)
                        score[numColumns + numRows + 2] = 0;
                    if (row == column-1)
                        score[numColumns + numRows + 3] = 0;
                    if (row == column-2)
                        score[numColumns + numRows + 4] = 0;
                    if (row == column-3)
                        score[numColumns + numRows + 5] = 0;
                    // update left diagonal score
                    if (row+2 == (numRows - 1 - column))
                        score[numColumns + numRows + 6] = 0;
                    if (row+1 == (numRows - 1 - column))
                        score[numColumns + numRows + 7] = 0;
                    if (row == (numRows - 1 - column))
                        score[numColumns + numRows + 8] = 0;
                    if (row == (numRows - column))
                        score[numColumns + numRows + 9] = 0;
                    if (row == (numRows - column + 1))
                        score[numColumns + numRows + 10] = 0;
                    if (row == (numRows - column + 2))
                        score[numColumns + numRows + 11] = 0;
    	        }
    	        for (int s = 0; s < 25; s++)
    	        {
    	            if (score[s] >= 4)
    	                return p1;
    	            if (score[s] <= -4)
    	                return p2;
    	        }
    	    }
    	}
    	
    	/*
    	if (isWinner(last.p1Board))
    	    return p1;
    	if (isWinner(last.p2Board))
    	    return p2;
    	*/
    	return null;
    }
    
    /*
    private boolean isWinner(int[][] board)
    {
        int y = board & (board >> 7);
        if (y & (y >> 2 * 7)) // check \ diagonal
            return true;
        y = board & (board >> 8);
        if (y & (y >> 2 * 8)) // check horizontal -
            return true;
        y = board & (board >> 9);
        if (y & (y >> 2 * 9)) // check / diagonal
            return true;
        y = board & (board >> 1);
        if (y & (y >> 2))     // check vertical |
            return true;
        return false;
    }
    */
    public List<GameState> getStateHistory()
    {
		return stateHistory;
	}
}
