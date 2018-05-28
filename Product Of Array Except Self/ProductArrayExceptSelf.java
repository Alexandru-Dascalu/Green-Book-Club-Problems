import java.util.Scanner;

public class ProductArrayExceptSelf
{
	public static void main(String[] args)
	{
		Scanner kb= new Scanner(System.in);
		System.out.println("Type in how many elements you want in your array:");
		int nrOfElements=kb.nextInt();
		
		int[] intArray=new int[nrOfElements];
		
		System.out.println("Type in that many numbers to put in the array,"+
				" each on a new line:");
		for(int i=0;i<nrOfElements;i++)
		{
			intArray[i]=kb.nextInt();
		}
		kb.close();
		
		System.out.println("Array before:");
		for(int i=0;i<nrOfElements;i++)
		{
			System.out.print(intArray[i]+", ");
		}
		
		productExceptSelf(intArray);
		
		System.out.println("\nArray after:");
		for(int i=0;i<nrOfElements;i++)
		{
			System.out.print(intArray[i]+", ");
		}
	}
	
	private static void productExceptSelf(int[] intArray)
	{
		int productOfElements=1;
		
		for(int i=0;i<intArray.length;i++)
		{
			productOfElements*=intArray[i];
		}
		
		for(int i=0;i<intArray.length;i++)
		{
			double inverseOfNumber=Math.pow(intArray[i], -1);
			double productExceptSelf=productOfElements*inverseOfNumber;
			intArray[i]=(int)productExceptSelf;
		}
	}
}
