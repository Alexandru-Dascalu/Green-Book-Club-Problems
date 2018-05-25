import java.util.LinkedList;

public class SerializeTreeMain
{
	public static void main(String[] args)
	{
		TreeNode<Integer> root=new TreeNode<>(null, Integer.valueOf(1));
		
		TreeNode<Integer> two=new TreeNode<Integer>(root,Integer.valueOf(2));
		root.setLeftChild(two);
		
		TreeNode<Integer> three=new TreeNode<Integer>(root,Integer.valueOf(3));
		root.setRightChild(three);
		
		TreeNode<Integer> four=new TreeNode<Integer>(root,Integer.valueOf(4));
		three.setLeftChild(four);
		
		TreeNode<Integer> five=new TreeNode<Integer>(root,Integer.valueOf(5));
		three.setRightChild(five);
		
		TreeNode<Integer> six=new TreeNode<Integer>(root,Integer.valueOf(6));
		four.setLeftChild(six);
		
		TreeNode<Integer> seven=new TreeNode<Integer>(root,Integer.valueOf(7));
		four.setRightChild(seven);
		
		LinkedList<LinkedList<TreeNode<Integer>>> listOfDepths=new LinkedList<>();
		makeListOfDepths(root,1,listOfDepths);
		
		System.out.println("The tree before being serialized: ");
		for(LinkedList<TreeNode<Integer>> list: listOfDepths)
		{
			for(TreeNode<Integer> node: list)
			{
				System.out.print(node.getElement().intValue()+" ");
			}
			System.out.println();
		}
		
		Integer[] serializedTree=TreeSerializer.getSerializedTree(root);
		
		System.out.println("The tree after being serialized: ");
		for(Integer i: serializedTree)
		{
			System.out.print(i+", ");
		}
		System.out.println();
		
		TreeNode<Integer> deserializedTree=TreeSerializer.getDeserializedTree(serializedTree);
		
		listOfDepths=new LinkedList<>();
		makeListOfDepths(deserializedTree,1,listOfDepths);
		
		System.out.println("The tree after being deserialized: ");
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
		//System.out.println("Added "+node.getElement().intValue()+" at depth "+depth);
		
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
