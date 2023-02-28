package code;
import java.util.*;

public class Board 
{
	int size;
	byte[][] board;
	//construct board of size
	Board(int size)
	{
		this.size = size;
		this.board = new byte[size][size];
	}
	//print board in current state
	public void print()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	//set a given coordinate to alive
	public void setAlive(int x, int y)
	{
		this.board[x][y] = (byte)1;
	}
	//count alive neighbours of a given coordinate
	public byte countAliveNeighbours(int x, int y)
	{
		byte alive = 0;
		alive += state(x-1,y-1);
		alive += state(x,y-1);
		alive += state(x+1,y-1);
		
		alive += state(x-1,y);
		alive += state(x+1,y);
		
		alive += state(x-1,y+1);
		alive += state(x,y+1);
		alive += state(x+1,y+1);
	return alive; 
	}
	//check state of a given coordinate
	public byte state(int x, int y)
	{
		if(x < 0 || x >= size)
		{
			return 0;
		}
		if(y < 0 || y >= size)
		{
			return 0;
		}
		return this.board[x][y];
	}
	//set random coordinates in range to alive
	public void setRandomAlive(Board b)
	{
		Random rand = new Random();
		int nset = rand.nextInt(5) + 1;
		for(int i = 0; i < nset; i++)
		{
			int randx = rand.nextInt(size);
			int randy = rand.nextInt(size);
			b.setAlive(randx, randy);
			if(randx != size - 1 && randy != size-1)
			{
			b.setAlive(randx + 1, randy +1);
		}
	}
	}
	//life algorithm
	public void life()
	{
		byte[][] finalBoard = new byte[size][size];
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				int aliveneighbours = countAliveNeighbours(i, j);
				if(state(i,j) == 1)
				{
					if(aliveneighbours < 2)
					{
						finalBoard[i][j] = 0;
					}
					else if(aliveneighbours == 2 || aliveneighbours == 3 )
					{
						finalBoard[i][j] = 1;
					}
					else
					{
						finalBoard[i][j] = 0;
					}
				}
				else
				{
					if(aliveneighbours == 3)
					{
						finalBoard[i][j] = 1;
					}
				}
			}
			System.out.println();
		}
		this.board = finalBoard;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Size of Board to Create");
		Board b1 = new Board(sc.nextInt());
		//set some board elements to alive state
		System.out.println("Do you want to set board states randomly? (Y/N)");
		char ans = sc.next().charAt(0);
		if(ans == 'Y' || ans == 'y')
		{
			b1.setRandomAlive(b1);
		}
		else 
		{
			b1.setAlive(1, 2);
			b1.setAlive(2, 2);
			b1.setAlive(3, 2);
		}
		System.out.println("Enter Number of Generations to Run");
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			System.out.println("Generation " + (i + 1));
			System.out.println("_________________");
			b1.print();
			b1.life();
		
		

	}
}
}
