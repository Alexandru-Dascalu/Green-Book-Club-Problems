import java.util.Scanner;
import java.lang.IllegalArgumentException;
/*Sherlock and the Valid String problem. 
 * Problem statement:
 * 
 * Sherlock considers a string to be valid if it all characters of the string appear 
 * the same number of times. It is also valid if he can remove just one character at one
 * index in the string, and the remaining characters will occur the same number of
 * times. Given a string , determine if it is valid.
 * 
 * For example, if s=abc , it is a valid string because frequencies are {a:1,b:1,c:1}. So 
 * is s=abcc because we can remove one c and have 1 of each character in the remaining string. 
 * If s=abccc however, the string is not valid as we can only remove occurrence 1 of c. That 
 * would leave character frequencies of {a:1, b:1, c:2}.
 * 
 * Input Format:
 * A single string s.
 * 
 * Constraints:
 * The length of s is between one and 100000 inclusive, and is made from lowercase ascii latin letters 
 * from the English Alphabet.
 * 
 * Output Format:
 * Print YES if string  is valid, otherwise, print NO.
 * 
 * Taken from https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem .*/

public class ValidString 
{
	public static void main (String[] args)
	{
		//read the string we will check from the keyboard
		System.out.println("Type in the string you want to see if it is valid or not:");
		String someString="";
		
		/*There are restrictions on the size of string and the characters it can have, 
		 * so we check and throw an exception if an incorrect string is typed in*/
		try
		{
			someString=getCorrectString();
		}
		//print error message and exit the program
		catch(IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
		/*We will go through the string and see how many times each letter is repeated. 
		 *We use an int array the size of the English Alphabet to do this.*/
		int [] charCount= new int[26];
		
		//create array where each position is the number of times a char is repeated
		for (int i=0; i<someString.length(); i++)
		{
			//a (ASCII 97)corresponds to index 0, b (ASCII 98) to index 1, etc.
			charCount[(int)(someString.charAt(i)) -97]++;
		}
		
		/*To solve the problem, we need to have a sense of how many times letters repeat 
		 *themselves on average. So we will calculate this average.*/
		double average=0;
		//counts how many unique letters are actually present, needed to calculate the average
		int actualCharacters=0;
				
		//count the number of actual characters present and the average of values
		for(int i=0; i<charCount.length; i++)
		{
			average=average+charCount[i];
			if(charCount[i]!=0)
			{
				actualCharacters++;
			}
		}
		
		for (int elem : charCount)
		{
			System.out.print(elem+", ");
		}
		System.out.print("\n");
		
		/*if its a valid string, most characters will appear about the same time, so we
		 * calculate an average of times characters appear*/
		average=average/actualCharacters;
		
		/*it should be an integer, the closest to the average, so this if does that*/
		if(average-Math.floor(average)>Math.ceil(average)-average)
		{
			average= Math.ceil(average);
		}
		else
		{
			average=Math.floor(average);
		}
		
		/*A string is valid if all the letters are repeated the same number of times, if 
		 *one letter is repeated one more time than the rest, or if one letter appears 
		 *just once and all the others are repeated the same number of times. So we count 
		 *when a letter is repeated as many times as the others, when its repeated just 
		 *once, and when its repeated one more time than the average*/
		
		//counts how many letters are repeated just once
		int one=0;
		//counts how many letters are repeated one more time than the average
		int greaterWithOne=0; 
		//counts how many letters are repeated as much as the average
		int repeated=0; 
		
		//we go through the charCount array and increment the above three counters
		for(int i=0; i<charCount.length; i++)
		{
			/*if it appeared the same times as the average, it appeared
			 *the same as most other characters*/
			if(charCount[i]==average)
			{
				repeated++;
			}
			/*if it appears once and 1 isnt the average, it is a character 
			 *we can remove to make the string valid*/
			else if(charCount[i]==1)
			{
				one++;
			}
			/*if it appears one more time than the average, we can remove to make 
			 *the string valid*/
			else if (charCount[i]==average+1)
			{
				greaterWithOne++;
			}
		}
		
		/*if every character repeats the same number of times as the average, it means 
		 * each character repeats the same number of times, it is valid*/
		if (repeated==actualCharacters)
		{
			System.out.print("YES");
		}
		/*else if only one is not repeated like the other, and it appears only
		 *once or one time more than the average, it is valid*/
		else if ((repeated==actualCharacters-1) && (one==1 || greaterWithOne==1))
		{
			System.out.print("YES");
		}
		//else it is not valid
		else
		{
			System.out.print("NO");
		}
		
	}
	
	//method checks if the inputed string is correct according to the limitations of problem statement
	private static String getCorrectString() throws IllegalArgumentException
	{
		//get the string from the keyboard
		Scanner kb=new Scanner(System.in);
		String answer=kb.nextLine();
		kb.close();
		
		//the string must not be empty
		if(answer.length()<1)
		{
			throw new IllegalArgumentException("You must type in a string of 1 or more "+
					"characters.");
		}
		//the string ant have more than 100000 characters
		else if(answer.length()>100000)
		{
			throw new IllegalArgumentException("You must type in a string of less than 10^5"+
					" characters.");
		}
		//the string can only have lower score a-z ASCII letters
		else
		{
			char letter;
			//go through the string and throw an exception if we find an invalid character
			for(int i=0;i<answer.length();i++)
			{
				letter=answer.charAt(i);
				
				if(letter<97 || letter>122)
				{
					throw new IllegalArgumentException("You must type in a string that only "+
						"has characters from ascii lowercase a to lowercase z inclusive.");
				}
			}
		}
		
		//if no exception has been thrown, return the string
		return answer;
	}
}
