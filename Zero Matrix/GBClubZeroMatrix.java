/* A solution for problem 1.8, Chapter 1, Section 9, page 91 from Cracking the Coding Interview.
 * We are given an matrix if integers and for every 0 element in the array,
 * we set it's entire row and column to zero.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class GBClubZeroMatrix 
{
	public static void main (String[] args)
	{
		//declare and initialize the int array from a file
		int[][] zeroMatrix= getMatrix();
		
		/*We create a linked list of MatrixPoint objects.Here we will store the position
		 *of the elements of the array that are equal to 0. A MatrixPoint is an object
		 *that stores 2 coordinates as integers.*/
		LinkedList<MatrixPoint> zeroes=new LinkedList<>();
		
		//represents the number of rows of the matrix
		int rows=zeroMatrix.length;
		
		//represents the number of columns of the matrix
		int columns=zeroMatrix[0].length;
		
		//we go through the array and add the 0 elements to the linked list
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				if(zeroMatrix[i][j]==0)
				{
					zeroes.add(new MatrixPoint(i,j));
				}
			}
		}
		
		/*we go through the linked list and set the rows and columns of these
		 *elements to 0*/
		for(MatrixPoint zeroPoint: zeroes)
		{
			//set all elements in the same row to 0
			for(int i=0;i<rows;i++)
			{
				zeroMatrix[i][zeroPoint.getYPos()]=0;
			}
			
			//set all elements in the same column to 0
			for(int i=0;i<columns;i++)
			{
				zeroMatrix[zeroPoint.getXPos()][i]=0;
			}
		}
		
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
