
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
		
		kb.close();
		return createBinaryTree(in);
	}
	
	private static TreeNode<Integer> createBinaryTree(Scanner in)
	{
		int value=1;
		TreeNode<Integer> root=new TreeNode<Integer>(null, Integer.valueOf(value));
		TreeNode<Integer> current;
		Scanner line=null;
		
		while(in.hasNextLine())
		{
			line=new Scanner(in.nextLine());
			
			value=line.nextInt();
			current=root.find(Integer.valueOf(value));
			value=line.nextInt();
			current.setLeftChild(new TreeNode<Integer>(current, Integer.valueOf(value)));
			
			if(line.hasNextInt())
			{
				value=line.nextInt();
				current.setRightChild(new TreeNode<Integer>(current, Integer.valueOf(value)));
			}
		}
		
		line.close();
		in.close();
		return root;
	}
}
