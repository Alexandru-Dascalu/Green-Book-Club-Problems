import java.util.LinkedList;
import java.util.Scanner;

public class PathsWithSum
{
	public static void main(String[] args)
	{
		TreeNode<Integer> root=BinaryTreeReader.getBinaryTree();
		LinkedList<TreePath> sumPaths=new LinkedList<>();
		
		System.out.println("Type in an integer: ");
		Scanner kb=new Scanner(System.in);
		int sum=kb.nextInt();
		
		int pathsWithSum=sumPaths(sum,null,root,sumPaths);
		
		System.out.println("There are "+pathsWithSum+" paths in the tree that amount to "+sum+".");
		
		for(TreePath p: sumPaths)
		{
			System.out.print(p.toString());
		}
		kb.close();
	}
	
	private static int sumPaths(int sum, TreePath currentPath, TreeNode<Integer> 
		currentNode,LinkedList<TreePath> sumPaths)
	{
		int count=0;
		if(currentPath==null)
		{
			currentPath=new TreePath();
		}
		
		currentPath.add(currentNode);
		
		if(currentPath.getSum()==sum)
		{
			TreePath newPath=new TreePath();
			newPath.setPath((LinkedList<TreeNode<Integer>>)
					currentPath.getPath().clone());
			sumPaths.add(newPath);
			count++;
		}
		
		if(currentNode.getLeftChild()!=null)
		{
			count+=sumPaths(sum,currentPath,currentNode.getLeftChild(),sumPaths);
			count+=sumPaths(sum,null,currentNode.getLeftChild(),sumPaths);
		}
		
		if(currentNode.getRightChild()!=null)
		{
			TreePath newPath=new TreePath(currentPath);
			count+=sumPaths(sum,newPath,currentNode.getRightChild(),sumPaths);
			count+=sumPaths(sum,null,currentNode.getRightChild(),sumPaths);
		}
		
		return count;
	}
}
