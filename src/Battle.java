import java.util.Scanner;
public class Battle {
	public static Player p = new Player("You");
	//Player Initialization
	
	public static Player e = new Player("The Computer");
	//Computer Initialization
	
	public static void main(String[] args) {
		Move.setComp(e, p);
		
		p.setUp();
		e.setUp();
		
		System.out.println("Your Grid:");
		p.printShipGrid();
		
		while(p.getShipCount() > 0 && e.getShipCount() > 0) {
			System.out.println("Your Ship Count:" + p.getShipCount());
			System.out.println("\nEnemy Ship Count: " + e.getShipCount());
			System.out.println("\nYour Grid:");
			p.printShipGrid();
			
			System.out.println("\nEnemy Grid:");
			p.printTrackingGrid();
			
			playerTurn();
			//User takes his or her turn and prints out the grid
			
			if(e.getShipCount() > 0){
				computerTurn();
			}
			//As long as the computer has ships, he takes his turn
			
			
			System.out.println("What the computer sees");
			e.printTrackingGrid();
		}
		
		if(p.getShipCount() > 0) {
			System.out.println("Congratulations, you have won.");
		}
		else {
			System.out.println("You lost.");
		}
		
		
		
		
		
		
	}
	
	public static void playerTurn() {
		Scanner input = new Scanner(System.in);
		int cChoice;
		char trChoice;
		int rChoice;
		
		System.out.println("Where would you like to fire?");
		
		System.out.println("Letter for Row:");
		trChoice = input.next().charAt(0);
		//Asks for an initial user input
		
		while(!Character.isLetter(trChoice)){
			System.out.println("Please enter a letter");
			trChoice = input.next().charAt(0);
		}
		//Forces the user to pick a letter
		
		while(!((trChoice >= 'A' && trChoice <= 'J') || (trChoice >= 'a' && trChoice <= 'j'))){
		    System.out.println("Please enter a letter from A to J");
		    trChoice = input.next().charAt(0);
		}
		//Forces the letter to be between a and j
		rChoice = charFix(trChoice);
		
		System.out.println("Number for Column:");
		cChoice = input.nextInt();
		//Asks for an initial column input
		
		while(!(cChoice >= 0 && cChoice <= 9)) {
			System.out.println("Please enter a number between 0 and 9");
			cChoice = input.nextInt();
		}
		//Forces the number to fall within the range 0 to 9
		
		p.fire(e, rChoice, cChoice);
		//The player fires at the computer
		
		
	}
	
	public static void computerTurn(){
		String m = Move.getMove();

		if(m == "") {
			int col = (int)(Math.random() * ((9 - 0) + 1));
			int row = (int)(Math.random() * ((9 - 0) + 1));
			//Random value between 0 and 9 for target location
			
			while(!p.checkTrackGrid(row, col)) {
				col = (int)(Math.random() * ((9 - 0) + 1));
				row = (int)(Math.random() * ((9 - 0) + 1));
			}
			
			e.fire(p, row, col);
			Move.recordHit(row, col);
			
		}
		//If the move class does not return a suggestion fires at a random location
		
		else {
			int x = Character.getNumericValue(m.charAt(0));
			int y = Character.getNumericValue(m.charAt(1));
			e.fire(p, x, y);
			Move.recordHit(x, y);
		}
		//fires based on the suggestion of the move class
		
	
	}
	 public static int charFix(char c)
	  {
	    switch (c) {
	    case 'A': case 'a': 
	      return 0;
	    case 'B': case 'b': 
	      return 1;
	    case 'C': case 'c': 
	      return 2;
	    case 'D': case 'd': 
	      return 3;
	    case 'E': case 'e': 
	      return 4;
	    case 'F': case 'f': 
	      return 5;
	    case 'G': case 'g': 
	      return 6;
	    case 'H': case 'h': 
	      return 7;
	    case 'I': case 'i': 
	      return 8;
	    case 'J': case 'j': 
	      return 9;
	    }
	    return -1;
	  }
}
