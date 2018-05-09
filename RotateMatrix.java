import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.IllegalStateException;

public class RotateMatrix
{
	public static void main (String args[])
	{
		int[][] squareMatrix=null;
		
		//get matrix and catch exception if it is not square
		try
		{
			squareMatrix=getMatrix();
		}
		catch (IllegalStateException e)
		{
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
		//print the initial matrix
		for(int i=0;i<squareMatrix.length;i++)
		{
			for(int j=0;j<squareMatrix.length;j++)
			{
				System.out.format("%-4d ",squareMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
				
		//2 variables used for swapping
		int temp1, temp2;
		
		//the biggest index in the matrix is one less than the length
		int maxIndex=squareMatrix.length-1;
		
		/*We rotate the matrix by rotating concentric square layers inside it, 
		 *starting from the outer one toward the inside, hence the loop will repeat
		 *length/2 times*/
		for(int i=0;i<(squareMatrix.length)/2;i++)
		{
			/*We rotate each square layer by starting from a number in the left
			 * part of the layer, moving it to its new place and saving the previous
			 * value to temp, moving that value to its new position, until we repeat 
			 * the process 4 times. Then, we execute the loop again ad start from the
			 * element that is directly down.*/
			for(int j=i;j<squareMatrix.length-i-1;j++)
			{
				temp1=squareMatrix[maxIndex-i][j];
				squareMatrix[maxIndex-i][j]=squareMatrix[j][i];
				
				temp2=squareMatrix[maxIndex-j][maxIndex-i];
				squareMatrix[maxIndex-j][maxIndex-i]=temp1;
				
				temp1=squareMatrix[i][maxIndex-j];
				squareMatrix[i][maxIndex-j]=temp2;
				
				squareMatrix[j][i]=temp1;
			}
		}
		
		//print the matrix to show the result
		for(int i=0;i<=maxIndex;i++)
		{
			for(int j=0;j<=maxIndex;j++)
			{
				System.out.format("%-4d ",squareMatrix[i][j]);
			}
			System.out.println();
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
