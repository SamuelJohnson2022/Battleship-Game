import java.util.Random;

public class Player {
	private ShipGrid shipGrid = new ShipGrid();
	private TrackGrid trackGrid = new TrackGrid();
	private Ship[] ship = new Ship[5];
	private int shipCount = 5;
	private String named;
	
	public Player(String name) {
		ship[0] = new Ship("Carrier", 5);
		ship[1] = new Ship("Battleship", 4);
		ship[2] = new Ship("Cruiser", 3);
		ship[3] = new Ship("Submarine", 3);
		ship[4] = new Ship("Destroyer", 2);
		named = name;
	}
	
	
	
	
	public void setUp() {
		
			Random rand = new Random();

		
			int vert = rand.nextInt(2);
			int col = rand.nextInt(9);
			int row = rand.nextInt(9);
		
			for(int i = 0; i < 5; i++) {
				while(!shipGrid.checkGrid(ship[i], vert, row, col)) {
					vert = rand.nextInt(2);
					col = rand.nextInt(9);
					row = rand.nextInt(9);		
				}
				
				shipGrid.placeShip(ship[i], vert, row, col);
			}
			
			
	}
	
	public Ship checkShipGrid(int row, int col) {
			return shipGrid.getShip(row, col);
		}
	
	public boolean checkTrackGrid(int row, int col) {
		if(trackGrid.checkPos(row, col) == '~') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void printShipGrid() {
		shipGrid.printGrid();
	}
	
	public void printTrackingGrid() {
		trackGrid.printGrid();
	}
	
	public int getShipCount() {
		return shipCount;
	}
	
	public void lostShip() {
			shipCount--;
	}
	
	public void fire(Player p, int row, int col) {
		if(p.checkShipGrid(row, col) == null) {
			System.out.println(named + " missed\n");
			trackGrid.track(false, row, col);
		}
		else{
			System.out.println(named + " hit an enemy ship\n");
			trackGrid.track(true, row, col);
			if(p.checkShipGrid(row, col).hit()) {
				System.out.println("You have sunk the enemy's " + p.checkShipGrid(row, col)	.getName());
				p.lostShip();
			}
		}
	}
	
	public char checkLastHit(int r, int c)
	{
		return trackGrid.checkPos(r, c);
	}

}

