public class Move {
	public static int lastC = -1;
	public static int lastR = -1;
	public static int firstC = -1;
	public static int firstR = -1;
	public static Player e;
	public static Player u;
	public static boolean right = true;
	public static boolean left = true;
	public static boolean up = true;
	public static boolean down = true;
	public static int shipCount = 5;
	
	public static void setComp(Player p1, Player p2)
	{
		e = p1;
		u = p2;
	}
	
	public static String getMove()
	{
		//No ship - No suggested move
		if(firstC == -1)
		{
			return "";
		}
		//GO RIGHT
		//(right) If we haven't checked to the right
		//(lastC+1 < 10) and we're not going off the edge of the map
		//(e.checkTrack) and we haven't already checked that spot
		if(right && lastC+1 < 10 && e.checkTrackGrid(lastR, lastC+1))
		{
			lastC++;
			return "" + lastR + lastC;
		}
		//GO LEFT
		else if(left &&  lastC-1 > -1 && e.checkTrackGrid(lastR, lastC-1))
		{
			lastC--;
			return "" + lastR + lastC;
		}
		//GO DOWN
		else if(down && lastR+1 < 10 && e.checkTrackGrid(lastR+1, lastC))
		{
			lastR++;
			return "" + lastR + lastC;
		}
		//GO UP
		else if(up && lastR-1 > -1 && e.checkTrackGrid(lastR-1, lastC))
		{
			lastR--;
			return "" + lastR + lastC;
		}
		return "";
		
	}
	
	public static void recordHit(int r, int c)
	{
		char s = e.checkLastHit(r, c);
		//System.out.println("RECORDING HIT AT " + r + " " + c);
		//System.out.println("firstC-" + firstC + " firstR-"+ firstR);
		//System.out.println("lastC-" + lastC + " lastR-"+ lastR);
		
		//If the ship has been sunk, reset all vars
		if(shipCount != u.getShipCount())
		{
			//System.out.println("SHIP HAS BEEN SUNK");
			firstC = -1; lastC = -1;
			firstR = -1; lastR = -1;	
			left = true; right = true;
			down = true; up = true;
			shipCount = u.getShipCount();
			getMove();
		}
		//If a new ship has been detected
		else if(s == 'X' && firstC == -1)
		{
			//System.out.println("HIT FOUND");
			firstC = c; lastC = c;
			firstR = r; lastR = r;	
			getOptions();
		}
		//I have a ship, but I missed
		else if(s == '*' && firstC != -1)
		{
			//System.out.println("GO BACK TO THE FIRST HIT");
			lastC = firstC;	lastR = firstR;
			
			if(right)
			{
				//System.out.println("STOP GOING RIGHT");
				right = false;
			}
			else if(left)
			{
				//System.out.println("STOP GOING LEFT");
				left = false;
			}
			else if(down)
			{
				//System.out.println("STOP GOING DOWN");
				down = false;
			}
			else if(up)
			{
				//System.out.println("STOP GOING UP");
				up = false;
			}
		}
	}
	
	//When a hit is first recorded, what directions are open?
	public static void getOptions()
	{
		//Can't go right
		if(firstC+1 == 10 || !e.checkTrackGrid(lastR, lastC+1))
		{
			right = false;
		}
		//can't go left
		if(lastC-1 == -1 || !e.checkTrackGrid(lastR, lastC-1))
		{
			left = false;
		}
		//Can't go down
		if(lastR+1 == 10 || !e.checkTrackGrid(lastR+1, lastC))
		{
			down = false;
		}
		//Can't go up
		if(lastR-1 == -1 || !e.checkTrackGrid(lastR-1, lastC))
		{
			up = false;
		}
	}
	
	
}