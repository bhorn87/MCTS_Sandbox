package horn.mcts;

import java.util.ArrayList;
import java.util.List;

public class UnitTesting
{

    public static void main(String[] args)
    {
        ConnectFourGame game = new ConnectFourGame();
        GameState init = new GameState();
        List<GameState> stateList = new ArrayList<GameState>();
        
        init.currentBoard[0][0] = 1;
        init.currentBoard[1][0] = 1;
        init.currentBoard[2][0] = 2;
        init.currentBoard[3][0] = 2;
        init.currentBoard[4][0] = 2;
        init.currentBoard[5][0] = 1;
        init.currentBoard[6][0] = 0;

        init.currentBoard[0][1] = 2;
        init.currentBoard[1][1] = 2;
        init.currentBoard[2][1] = 2;
        init.currentBoard[3][1] = 1;
        init.currentBoard[4][1] = 1;
        init.currentBoard[5][1] = 2;
        init.currentBoard[6][1] = 0;
        
        init.currentBoard[0][2] = 0;
        init.currentBoard[1][2] = 0;
        init.currentBoard[2][2] = 1;
        init.currentBoard[3][2] = 1;
        init.currentBoard[4][2] = 0;
        init.currentBoard[5][2] = 0;
        init.currentBoard[6][2] = 0;
        
        init.currentBoard[0][3] = 0;
        init.currentBoard[1][3] = 0;
        init.currentBoard[2][3] = 1;
        init.currentBoard[3][3] = 1;
        init.currentBoard[4][3] = 0;
        init.currentBoard[5][3] = 0;
        init.currentBoard[6][3] = 0;
        
        init.currentBoard[0][4] = 0;
        init.currentBoard[1][4] = 0;
        init.currentBoard[2][4] = 0;
        init.currentBoard[3][4] = 2;
        init.currentBoard[4][4] = 0;
        init.currentBoard[5][4] = 0;
        init.currentBoard[6][4] = 0;
        
        init.currentBoard[0][5] = 0;
        init.currentBoard[1][5] = 0;
        init.currentBoard[2][5] = 0;
        init.currentBoard[3][5] = 0;
        init.currentBoard[4][5] = 0;
        init.currentBoard[5][5] = 0;
        init.currentBoard[6][5] = 0;
        
        stateList.add(init);
        Player winner = game.winner(stateList);
        System.out.println("Winner: " + winner);
        
        
        GameBoard g1 = new ConnectFourGame();
        System.out.println("numColumns g1: " + ((ConnectFourGame)g1).numColumns);
        GameBoard g2 = null;
        g2 = g1.copy();
        System.out.println("numColumns g2: " + ((ConnectFourGame)g2).numColumns);
        ((ConnectFourGame)g2).numColumns = 10;
        System.out.println("again numColumns g1: " + ((ConnectFourGame)g1).numColumns);
        System.out.println("again numColumns g2: " + ((ConnectFourGame)g2).numColumns);
    }

}
