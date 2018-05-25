
public class TreeSerializer
{
	public static Integer[] getSerializedTree(TreeNode<Integer> tree)
	{
		int height=getHeight(tree,0,0);
	
		Integer[] serializedTree=new Integer[(int)(Math.pow(2, height)-1)];
		
		serializeTree(serializedTree,tree,0);
		
		return serializedTree;
	}
	
	private static void serializeTree(Integer[] serializedTree, TreeNode<Integer> currentNode, int position)
	{
		serializedTree[position]=currentNode.getElement();
		
		if(currentNode.getLeftChild()!=null)
		{
			serializeTree(serializedTree,currentNode.getLeftChild(),2*position+1);
		}
		
		if(currentNode.getRightChild()!=null)
		{
			serializeTree(serializedTree,currentNode.getRightChild(),2*position+2);
		}
	}
	
	public static TreeNode<Integer> getDeserializedTree(Integer[] serializedTree)
	{
		return deserializeTree(serializedTree,0,null);
	}
	
	private static TreeNode<Integer> deserializeTree(Integer[] serializedTree, 
			int position, TreeNode<Integer> parent)
	{
		TreeNode<Integer> newNode=new TreeNode<>(parent, serializedTree[position]);
		
		if(position*2+2<=serializedTree.length)
		{
			if(serializedTree[position*2+1]!=null)
			{
				TreeNode<Integer> leftChild=deserializeTree(serializedTree, position*2+1,newNode);
				newNode.setLeftChild(leftChild);
			}
			
			if(serializedTree[position*2+2]!=null)
			{
				TreeNode<Integer> rightChild=deserializeTree(serializedTree, position*2+2,newNode);
				newNode.setRightChild(rightChild);
			}
		}
		return newNode;
	}
	
	private static int getHeight(TreeNode<Integer> currentNode,int parentLevel, int height)
	{
		int level=parentLevel+1;
		
		if(level>height)
		{
			height=level;
		}
		
		if(currentNode.getLeftChild()!=null)
		{
			int maxChildLevel=getHeight(currentNode.getLeftChild(),level,height);
			if(height<maxChildLevel)
			{
				height=maxChildLevel;
			}
		}
		
		if(currentNode.getRightChild()!=null)
		{
			int maxChildLevel=getHeight(currentNode.getRightChild(),level,height);
			if(height<maxChildLevel)
			{
				height=maxChildLevel;
			}
		}
		
		return height;
	}
}
