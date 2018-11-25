/**
 * Solution to the problem:
 * Given an array of random numbers, push all the zero’s of a given array to the
 * end of the array. For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, 
 * it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. 
 * 
 * This solution is O(n) in runtime complexity and O(1) in space complexity.
 * @author Alexandru Dascalu
 */

public class MoveZeroes
{
	public static void main(String[] args)
	{
		//int[] someArray = {1, 3, 5, 2, 0, 9, 0, 11, 0};
		int[] someArray = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
		
		cout("Before:\n");
		for(int i=0; i<someArray.length; i++)
		{
			cout(someArray[i]+", ");
		}
		cout("\n\n");
		
		moveZeroesToEnd(someArray);
		
		cout("After:\n");
		for(int i=0; i<someArray.length ;i++)
		{
			cout(someArray[i]+", ");
		}
	}
	
	//just prints the given string, here to make print command shorter
	private static void cout (String line)
	{
		System.out.print(line);
	}
	
	//method that modifies the given array to push all zeroes to the end
	private static void moveZeroesToEnd(int[] someArray)
	{
		//a counter for the number of zeroes encountered so far in the array
		int zeroCounter=0;
		
		for(int i=0; i< someArray.length; i++)
		{
			/*if the current element is zero, we increment the zero counter,
			 * and since this zero is at the end of the array being 
			 * searched so far, we do nothing.*/
			if(someArray[i]==0)
			{
				zeroCounter++;
			}
			/*Else, if the element is not zero, we swap it so a zero is in it's place*/
			else
			{
				//Check if there are zeroes before this non zero element
				if(zeroCounter!=0)
				{
					/*If so, we put the non zero number at the current index minus 
					 * however many zeroes there are so far, and set the original 
					 * index to 0. We know that before this non zero number there
					 * is a number of zeroes in succession, because for any 
					 * previous index we ensured all non zero numbers are set back 
					 * and a zero is put in their place.*/
					someArray[i-zeroCounter]=someArray[i];
					someArray[i]=0;
				}
			}
		}
	}
}