
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class TreeDescriptionReader
{
	public static int[] getTreeDescription() 
	{
		Scanner kb=new Scanner(System.in);
		System.out.println("Type the name of the file you want to create the Integer Binary Tree from:");
		String fileName=kb.nextLine();
		Scanner in=null;
		
		try
		{
			in=new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
		kb.close();
		return getNodeList(in);
	}
	
	private static int[] getNodeList(Scanner in)
	{
		ArrayList<Integer> sortedList=new ArrayList<>();
		while(in.hasNextInt())
		{
			int newValue=in.nextInt();
			sortedList.add(Integer.valueOf(newValue));
		}
		
		int treeDescription[]=new int[sortedList.size()];

		for(int i=0;i<sortedList.size();i++)
		{
			treeDescription[i]=sortedList.get(i);
		}
		
		in.close();
		return treeDescription;
	}
}
