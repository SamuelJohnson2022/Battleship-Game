public class Ship {
	
	private String name;
	private int length;
	private int damage = 0;

	public Ship(String String1, int Int1)
	{
		name = String1;
		length = Int1;
	}
	
	public boolean hit()
	{
		damage += 1;
		if(damage == length)
		{
			return true;
		}
		return false;
	}
	public String getName()
	{
		return name;
	}
	public int getLength()
	{
		return length;
	}

}
