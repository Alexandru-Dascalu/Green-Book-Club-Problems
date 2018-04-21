import java.util.Scanner;

public class SuperDigit
{
	public static void main (String[] args)
	{
		Scanner kb=new Scanner (System.in);
		
		int n=kb.nextInt();
		int k=kb.nextInt();
		int superDigit=0,copy, nLength=0;
		
		//so that we do not lose the value of n when finding its length
		copy=n;
		
		//find out the number of digits n has
		while (copy>0)
		{
			copy=copy/10;
			nLength++;
		}
		
		//concatenate n three times
		for (;k>0;k--)
		{
			//multiply it so that we have room for n
			for(int i=nLength;i>0;i--)
			{
				superDigit*=10;
			}
			
			superDigit+=n;
		}
		
		//call out the method
		System.out.println("The super digit of "+superDigit+" is "+superNumber(superDigit));
		
		kb.close();
		
	}
	
	private static int superNumber(int superDigit)
	{
		if(superDigit>9)
		{
			int sum=0;
			
			//we calculate the sum of its digits
			while(superDigit>0)
			{
				sum+=superDigit%10;
				superDigit=superDigit/10;
			}
			
			//call out the method recursively
			superDigit=superNumber(sum);
			return superDigit;
		}
		else 
		{
			// if its a single digit then we just return it
			return superDigit;
		}
	}
}
