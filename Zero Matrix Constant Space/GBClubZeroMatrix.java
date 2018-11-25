/** A solution for a modified version of problem 1.8, Chapter 1, Section 9, 
 * page 91 from Cracking the Coding Interview.
 * We are given an matrix if integers and for every 0 element in the array,
 * we set it's entire row and column to zero, and the space complexity of the
 * solution must be O(1).
 * 
 * My solution has a runtime complexity of O(n).
 * @author Alexandru Dascalu.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GBClubZeroMatrix 
{
	/*A flag used to mark zero elements in the matrix. The flag could be any 
	 * number except 0 and 1.*/
	private static final int ZERO_FLAG=-1;
	
	public static void main (String[] args)
	{
		//declare and initialise the int array from a file
		int[][] zeroMatrix= getMatrix();
		
		//represents the number of rows of the matrix
		int rows=zeroMatrix.length;
		
		//represents the number of columns of the matrix
		int columns=zeroMatrix[0].length;
		
		System.out.println("Before:");
		//print the matrix
		for(int i=0;i<rows;i++)
		{
			
			for(int j=0;j<columns;j++)
			{
				System.out.format("%-4d ",zeroMatrix[i][j]);
			}
			System.out.println();
		}
				
		//we go through the array and mark slots where there is a zero number
		//with a flag
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				if(zeroMatrix[i][j]==0)
				{
					zeroMatrix[i][j]=ZERO_FLAG;
				}
			}
		}
		
		/*we go through the linked list and set the rows and columns of 
		 * elements marked with -1 to 0.*/
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				if(zeroMatrix[i][j]==ZERO_FLAG)
				{
					nullifyRowColumn(i, j, zeroMatrix);
				}
			}
		}
		
		System.out.println("After:");
		//print the matrix to show the result
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				System.out.format("%-4d ",zeroMatrix[i][j]);
			}
			System.out.println();
		}
	}
	
	//nullifies the row and column at the given indexes
	private static void nullifyRowColumn(int rowIndex, int columnIndex, int[][] zeroMatrix)
	{
		for(int i=0; i<zeroMatrix[0].length; i++)
		{
			zeroMatrix[rowIndex][i]=0;
		}
		
		for(int i=0; i<zeroMatrix.length;i++)
		{
			zeroMatrix[i][columnIndex]=0;
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
