package horn.mcts;

public class Player 
{
    private String pName;
    public Player(String name)
    {
        pName = name;
    }
    
    public String getName()
    {
        return pName;
    }
    
    public String toString()
    {
        return pName;
    }
    
    public Player copy()
    {
        Player newPlayer = new Player(this.pName);
        return newPlayer;
    }
}
