
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinaryTreeReader
{
	public static TreeNode<Integer> getBinaryTree() 
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
		
		return createBinaryTree(in);
	}
	
	private static TreeNode<Integer> createBinaryTree(Scanner in)
	{
		int value;
		TreeNode<Integer> root=null;
		TreeNode<Integer> current;
		Scanner line=null;
		int counter=0;
		
		while(in.hasNextLine())
		{
			line=new Scanner(in.nextLine());
			
			value=line.nextInt();
			
			if(counter==0)
			{
				root=new TreeNode<Integer>(null, Integer.valueOf(value));
			}
	
			current=root.find(Integer.valueOf(value));
			value=line.nextInt();
			current.setLeftChild(new TreeNode<Integer>(current, Integer.valueOf(value)));
			
			if(line.hasNextInt())
			{
				value=line.nextInt();
				current.setRightChild(new TreeNode<Integer>(current, Integer.valueOf(value)));
			}
			
			counter++;
		}
		
		line.close();
		in.close();
		return root;
	}
}
