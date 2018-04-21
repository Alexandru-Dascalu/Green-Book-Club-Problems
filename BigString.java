import java.util.Scanner;

public class BigString 
{
	public static void main (String[] args)
	{
		
		Scanner kb=new Scanner (System.in);
		
		String bigString;
		System.out.print("Type in string");
		bigString=kb.nextLine();
		String smallString;
		int smallStringLength=1, compareIndex=1;
		smallString=bigString.substring(0,1);
		
		boolean isNotFinished=true;
		
		while(isNotFinished)
		{
			if(!smallString.equals(bigString.substring(compareIndex, compareIndex+smallStringLength)))
			{
				smallStringLength++;
				smallString=bigString.substring(0,smallStringLength);
				compareIndex=smallStringLength;
				
				if(smallStringLength>bigString.length()/2)
				{
					smallString=bigString;
					isNotFinished=false;
				}
			}
			else
			{
				compareIndex+=smallStringLength;
				if(compareIndex==bigString.length())
				{
					isNotFinished=false;
				}
			}
		}
		
		System.out.print(smallString);
		
		kb.close();
		
		
		
		
	}
}
