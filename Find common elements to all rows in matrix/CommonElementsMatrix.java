import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

public class CommonElementsMatrix
{
	public static void main (String[] args)
	{
		int squareMatrix[][]=null;
		
		try
		{
			squareMatrix=getMatrix();
		}
		catch(IllegalStateException e)
		{
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
		HashMap<Integer, Integer> previousRow;
		HashMap<Integer, Integer> currentRow=new HashMap<>();
		Integer current;
		
		for(int i=0;i<squareMatrix[0].length;i++)
		{
			current=Integer.valueOf(squareMatrix[0][i]);
			currentRow.put(current, current.hashCode());
		}
		
		for(int i=1;i<squareMatrix.length;i++)
		{
			previousRow=currentRow;
			currentRow=new HashMap<>();
			
			for(int j=0;j<squareMatrix[i].length;j++)
			{
				current=Integer.valueOf(squareMatrix[i][j]);
				if(previousRow.containsKey(current))
				{
					currentRow.put(current, current.hashCode());
				}
			}
		}
		
		Iterator<Integer> keyIterator=currentRow.keySet().iterator();
		String key;
		
		System.out.println("The numbers that are common to all rows of the matrix"+
				" are: ");
		while(keyIterator.hasNext())
		{
			key=keyIterator.next().toString();
			System.out.print(key+" ");
		}
	}
	
	/*Method reads the name of a file and reads a matrix from the file*/
	private static int[][] getMatrix()
	{
		//read the name of the file from the keyboard
		Scanner kb=new Scanner(System.in);
		System.out.println("Type the name of the file you want to read the int matrix from:");
		String fileName=kb.nextLine();
		
		//declare and initialize the the file scanner
		Scanner in=null;
		
		//make a new scanner tied to the file, throw an exception if the file does not exist
		try
		{
			in=new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
		//close keyboard scanner
		kb.close();
		
		//read the number of rows and columns of the matrix
		int rows, columns;
		rows=in.nextInt();
		columns=in.nextInt();
		
		if(rows!=columns)
		{
			throw new IllegalStateException("The file that you requested does "+
					"not have a square matrix!");
		}
		
		//make the matrix
		int[][] zeroMatrix=new int[rows][columns];
		
		//read the elements of the matrix from the file
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				zeroMatrix[i][j]=in.nextInt();
			}
		}
		
		in.close();
		return zeroMatrix;
	}
}
