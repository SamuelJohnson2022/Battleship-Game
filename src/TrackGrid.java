public class TrackGrid {

	private char [][] grid = new char [10][10];
	
	public TrackGrid()
	{
		for(int x = 0; x < 10; x++)
		{
			for(int y =0; y < 10; y++)
			{
				grid [x][y] = '~';
			}
		}
	}
	public void track(boolean Bool1, int Int1, int Int2)
	{
		if(Bool1)
		{
			grid[Int1][Int2] = 'X';
		}
		else
		{
			grid[Int1][Int2] = '*';
		}
	}
	public char checkPos(int row, int col)
	{
		return grid[row][col];
	}
	public void printGrid()
	{
		char a = 65;
		
		System.out.print("  ");
		for(int x = 0; x < 10; x++)
		{
			System.out.print(x + " ");
		}
		System.out.println();
		
		for(int x = 0; x < 10; x++)
		{
			System.out.print(a + " ");
			for(int y = 0; y < 10; y++)
			{
				System.out.print(grid[x][y] + " ");
			}
			System.out.println();
			a++;
		}
		
		
	}
}


