import java.util.LinkedList;

public class ListOfDepths
{
	public static void main(String[] args)
	{
		TreeNode<Integer> root=BinaryTreeReader.getBinaryTree();
		LinkedList<LinkedList<TreeNode<Integer>>> listOfDepths=new LinkedList<>();
				
		makeListOfDepths(root,1,listOfDepths);
		
		for(LinkedList<TreeNode<Integer>> list: listOfDepths)
		{
			for(TreeNode<Integer> node: list)
			{
				System.out.print(node.getElement().intValue()+" ");
			}
			System.out.println();
		}
	}
	
	private static void makeListOfDepths(TreeNode<Integer> node, int depth,
			LinkedList<LinkedList<TreeNode<Integer>>> listOfDepths)
	{
		if(depth>listOfDepths.size())
		{
			listOfDepths.add(new LinkedList<TreeNode<Integer>>());
		}
		
		listOfDepths.get(depth-1).add(node);
		System.out.println("Added "+node.getElement().intValue()+" at depth "+depth);
		
		if(node.getLeftChild()!=null)
		{
			makeListOfDepths(node.getLeftChild(),depth+1,listOfDepths);	
		}
		
		if(node.getRightChild()!=null)
		{
			makeListOfDepths(node.getRightChild(),depth+1,listOfDepths);
		}
	}
}
