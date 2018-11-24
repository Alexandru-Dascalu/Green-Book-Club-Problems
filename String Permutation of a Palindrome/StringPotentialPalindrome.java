import java.util.HashMap;

/**Solution to the String Palindrome permutation problem:
 * Given a string, check if the string is a permutation of a palindrome, meaning 
 * that it's letters could be rearranged such that they will form a palindrome.
 * @author Alexandru Dascalu.
 */

public class StringPotentialPalindrome
{
	public static void main (String[] args)
	{
		String someString="llkandfkal";
		System.out.println("The string is: "+ someString);
		System.out.println("Is it a permutation of a palindrome?"+canBeAPalindrome(someString));
		
		someString = "geeksogeeks";
		System.out.println("The string is: "+ someString);
		System.out.println("Is it a permutation of a palindrome?"+canBeAPalindrome(someString));
	}
	
	private static boolean canBeAPalindrome(String someString)
	{
		HashMap<Character, Integer> charOccurences =  new HashMap<Character, Integer>();
		
		/*Go through the string once, put the characters you find in the hashmap 
		 * and make them map to a counter that represents the number of times 
		 * that character has appeared so far in the string.*/
		for(int i=0; i<someString.length(); i++)
		{
			//get the value of characters in the string as a Character object
			Character letter= Character.valueOf(someString.charAt(i));
			
			//if the key is already in the hashmap, increase it's value by 1
			if(charOccurences.containsKey(letter))
			{
				int occurences=charOccurences.get(letter).intValue();
				charOccurences.put(letter, Integer.valueOf(occurences+1));
			}
			//else, put the key in the map with a value of 1 since it is the 
			//first time we have found this character
			else
			{
				charOccurences.put(letter, Integer.valueOf(1));
			}
		}
		
		/*A palindrome can be made from only pairs of characters or have one non
		 * paired character at most. We count the number of distinct characters
		 * that appear an odd number of times. The string is a permutation of 
		 * palindrome if the count is 0 or 1.*/
		int oddAppearances=0;
		for(Integer number: charOccurences.values())
		{
			if(number.intValue()%2==1)
			{
				oddAppearances++;
			}
			
			if(oddAppearances>1)
			{
				return false;
			}
		}
		
		return true;
	}
}
