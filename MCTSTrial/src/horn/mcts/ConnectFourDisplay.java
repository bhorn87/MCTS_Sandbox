package horn.mcts;

import processing.core.PApplet;

public class ConnectFourDisplay extends PApplet
{
    private ConnectFourGame g = null;
    
    private float p1red = 255.0f;
    private float p1green = 0.0f;
    private float p1blue = 0.0f;
    
    private float p2red = 0.0f;
    private float p2green = 0.0f;
    private float p2blue = 0.0f;
    
    public  void settings()
    {
        displayWidth = 700;
        displayHeight = 600;
        size(displayWidth,displayHeight);
    }
    
    public void setup()
    {
        System.out.println("Starting");
        g = new ConnectFourGame();
        g.initialize();

    }
    
    public void draw()
    {        
        ellipseMode(CENTER);
        background(200,200,200);
        //column markers
        line(0,0,0,600);
        line(100,0,100,600);
        line(200,0,200,600);
        line(300,0,300,600);
        line(400,0,400,600);
        line(500,0,500,600);
        line(600,0,600,600);
        line(700,0,700,600);
        
        //row markers
        line(0,0,700,0);
        line(0,100,700,100);
        line(0,200,700,200);
        line(0,300,700,300);
        line(0,400,700,400);
        line(0,500,700,500);
        line(0,600,700,600);
        
        if (g.getStateHistory() == null)
        {
            System.out.println("AHH! StateHistory is null! Exiting.");
            System.exit(0);
        }
        
        GameState curr = g.getStateHistory().get(g.getStateHistory().size() - 1);
        if (g.winner(g.getStateHistory()) != null)
        {
            fill(0,0,255);
            text(g.winner(g.getStateHistory()).getName() + " wins!",10,10);
        }
        else if (curr.currentPlayer == 1)
        {
            fill(255,0,0);
            text(g.getCurrentPlayer(curr).getName(),10,10);
        }
        else
        {
            fill(0,0,0);
            text(g.getCurrentPlayer(curr).getName(),10,10);
        }
        // drawing the pieces
        for (int column = 0; column < g.numColumns; column++)
        {
            for (int row = 0; row < g.numRows; row++)
            {
                if (curr.currentBoard[column][row] == 1)
                {
                   fill(p1red,p1green,p1blue);
                   ellipse(column*100+50,row*100+50,50,50);
                }
                else if (curr.currentBoard[column][row] == 2)
                {
                    fill(p2red,p2green,p2blue);
                    ellipse(column*100+50,row*100+50,50,50);
                }
                else
                {
                    fill(255,255,255);
                    ellipse(column*100+50,row*100+50,50,50);
                }
            }
        }
        /*
        else
        {
            System.out.println("game over");
            System.out.println("Winner: " + g.winner(g.getStateHistory()).getName());
            g.printBoard();
            //exit();
        }
        */
//        if (mousePressed)
//        {
//            getColumnPressed();
//        }
    }

	public static void main(String[] args) 
	{		
	    PApplet.main(new String[] { "--present", "horn.mcts.ConnectFourDisplay" });
	}
	
	public void mouseClicked()
	{
	    if (g.winner(g.getStateHistory()) == null)
	    {
            if(mouseX >= 0 && mouseX < 100)
            {
                System.out.println("The mouse is pressed and over column 0");
                g.getNextGameState(g.getStateHistory().get(g.getStateHistory().size() - 1), 0);
            }
            else if(mouseX >= 100 && mouseX < 200)
            {
                System.out.println("The mouse is pressed and over column 1");
                g.getNextGameState(g.getStateHistory().get(g.getStateHistory().size() - 1), 1);
            }
            else if(mouseX >= 200 && mouseX < 300)
            {
                System.out.println("The mouse is pressed and over column 2");
                g.getNextGameState(g.getStateHistory().get(g.getStateHistory().size() - 1), 2);
            }
            else if(mouseX >= 300 && mouseX < 400)
            {
                System.out.println("The mouse is pressed and over column 3");
                g.getNextGameState(g.getStateHistory().get(g.getStateHistory().size() - 1), 3);
            }
            else if(mouseX >= 400 && mouseX < 500)
            {
                System.out.println("The mouse is pressed and over column 4");
                g.getNextGameState(g.getStateHistory().get(g.getStateHistory().size() - 1), 4);
            }
            else if(mouseX >= 500 && mouseX < 600)
            {
                System.out.println("The mouse is pressed and over column 5");
                g.getNextGameState(g.getStateHistory().get(g.getStateHistory().size() - 1), 5);
            }
            else if(mouseX >= 600 && mouseX < 700)
            {
                System.out.println("The mouse is pressed and over column 6");
                g.getNextGameState(g.getStateHistory().get(g.getStateHistory().size() - 1), 6);
            }
	    }
	}
}
