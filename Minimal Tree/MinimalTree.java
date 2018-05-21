import java.util.LinkedList;

public class MinimalTree
{
	public static void main(String[] args)
	{
		int[] treeDescription=TreeDescriptionReader.getTreeDescription();
		TreeNode<Integer> root=createMinHeightBST(treeDescription,0,treeDescription.length-1,null);
		
		root.print(0);
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
	
	private static TreeNode<Integer> createMinHeightBST(int[] treeDescription, int left, int right,
			TreeNode<Integer> parent)
	{
		if(right<left)
		{
			return null;
		}
		else if(right==left)
		{
			TreeNode<Integer> newNode=new TreeNode<>(parent, Integer.valueOf(treeDescription[left]));
			return newNode;
		}
		else
		{
			int middle=(right+left)/2;
			TreeNode<Integer> newNode=new TreeNode<>(parent, Integer.valueOf(treeDescription[middle]));
			
			newNode.setLeftChild(createMinHeightBST(treeDescription,left,middle-1,newNode));
			newNode.setRightChild(createMinHeightBST(treeDescription,middle+1,right,newNode));
			
			return newNode;
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
