/*Class represents an element in a matrix, storing its coordinates as 2 integers*/
public class MatrixPoint
{
	//the row number of the element
	private final int xPos;
	//the column number of the element
	private final int yPos;
	
	//makes a new MatrixPoint object with the x and y coordinates as parameters
	public MatrixPoint(int xPos, int yPos)
	{
		this.xPos=xPos;
		this.yPos=yPos;
	}
	
	//returns the row number of the element
	public int getXPos()
	{
		return xPos;
	}
	
	//returns the column number of the element
	public int getYPos()
	{
		return yPos;
	}
}
