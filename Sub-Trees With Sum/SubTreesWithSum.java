import java.util.LinkedList;
import java.util.Scanner;

public class SubTreesWithSum
{
	public static void main(String[] args)
	{
		TreeNode<Integer> root=BinaryTreeReader.getBinaryTree();
		LinkedList<TreeNode<Integer>> sumTrees=new LinkedList<>();
		
		System.out.println("Type in an integer: ");
		Scanner kb=new Scanner(System.in);
		int sum=kb.nextInt();
		
		sumTrees(sum,root,sumTrees);
		
		System.out.println("There are "+sumTrees.size()+" paths in the tree"+
				" that amount to "+sum+".");
		
		for(TreeNode<Integer> node: sumTrees)
		{
			System.out.print(node.toString());
		}
		
		kb.close();
	}
	
	private static int sumTrees(int sum,TreeNode<Integer> currentNode, 
			LinkedList<TreeNode<Integer>> sumTrees)
	{
		int treeSum=currentNode.getElement().intValue();
		
		if(currentNode.getLeftChild()!=null)
		{
			treeSum+=sumTrees(sum,currentNode.getLeftChild(), sumTrees);
		}
		
		if(currentNode.getRightChild()!=null)
		{
			treeSum+=sumTrees(sum,currentNode.getRightChild(), sumTrees);
		}
		
		if(treeSum==sum)
		{
			sumTrees.add(currentNode);
		}
		
		return treeSum;
	}
}
