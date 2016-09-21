package horn.mcts;

public class ConnectFourDisplay 
{

	public static void main(String[] args) 
	{
		System.out.println("Starting");
		ConnectFourGame g = new ConnectFourGame();
		g.initialize();
		g.winner(g.getStateHistory());
	}

}
