import java.util.Scanner;

public class ProductArrayExceptSelf
{
	public static void main(String[] args)
	{
		//read the size of the array
		Scanner kb= new Scanner(System.in);
		System.out.println("Type in how many elements you want in your array:");
		int nrOfElements=kb.nextInt();
		
		//make the array with the right size
		int[] intArray=new int[nrOfElements];
		
		//read the array elements
		System.out.println("Type in that many numbers to put in the array,"+
				" each on a new line:");
		for(int i=0;i<nrOfElements;i++)
		{
			intArray[i]=kb.nextInt();
		}
		kb.close();
		
		//display the array before
		System.out.println("Array before:");
		for(int i=0;i<nrOfElements;i++)
		{
			System.out.print(intArray[i]+", ");
		}
		
		//calculate output array
		int[] output=productExceptSelf(intArray);
		
		//display the output array
		System.out.println("\nArray after:");
		for(int i=0;i<nrOfElements;i++)
		{
			System.out.print(output[i]+", ");
		}
	}
	
	private static int[] productExceptSelf(int[] intArray)
	{
		int[] output=new int [intArray.length];
		//one is the neutral element for multiplication
		int productOfElements=1;
		
		//we calculate the total product of the elements in the input array
		for(int i=0;i<intArray.length;i++)
		{
			productOfElements*=intArray[i];
		}
		
		/*we calculate the product of the array without that element and without
		division by raising the current element to the -1 power, thus getting its 
		inverse number, then multiply the inverse number with the total product to 
		get the product without the current element*/
		for(int i=0;i<intArray.length;i++)
		{
			double inverseOfNumber=Math.pow(intArray[i], -1);
			double productExceptSelf=productOfElements*inverseOfNumber;
			output[i]=(int)productExceptSelf;
		}
		
		return output;
	}
}
