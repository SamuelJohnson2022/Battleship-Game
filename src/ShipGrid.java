public class ShipGrid {
  private Ship[][] grid = new Ship[10][10];
  
  public ShipGrid() {}
  
  public Ship getShip(int row, int col) {
    return grid[row][col];
  }
  public boolean checkGrid(Ship ship, int vert, int row, int col)
  {

    if ((vert == 0))
    {
    	if(ship.getLength() + col > 10) {
 
    		return false;
    	}
    }
    if ((vert == 1))
    {
    	if(ship.getLength() + row > 10) {
    		
    		return false;
    	}
    }
    int j;
    if (vert == 0)
    {

      for (j = 0; j < ship.getLength(); j++)
      {
        if (getShip(row, col) != null)
        {
          return false;
        }
        col++;
      }  
    }
    else
    {
      for (j = 0; j < ship.getLength(); j++)
      {
        if (getShip(row, col) != null)
        {
          return false;
        }
        row++;
      }
    }
    
    return true;
  }
  public void placeShip(Ship ship, int vert, int row, int col)
  {
    if (vert == 0)
    {
      for (int j = 0; j < ship.getLength(); j++)
      {
        grid[row][col] = ship;
        col++;
      }
    }
    else
    {
      for (int j = 0; j < ship.getLength(); j++)
      {
        grid[row][col] = ship;
        row++;
      }
    }
  }
  public void printGrid()
  {
    char c = 'A';
    
    System.out.print("   ");
    
    for (int i = 0; i < 10; i++)
    {
      System.out.print(i + " ");
    }
    System.out.println();
    
    for (int i = 0; i < 10; i++)
    {
      System.out.print(c + "  ");
      c = (char)(c + '\001');
      for (int j = 0; j < 10; j++)
      {
        if (grid[i][j] == null)
        {
          System.out.print("~ ");

        }
        else
        {
          System.out.print(grid[i][j].getLength() + " ");
        }
      }
      System.out.print("\n");
    }
    System.out.print("\n\n");
  }
}