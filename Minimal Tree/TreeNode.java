
public class TreeNode<E>
{
	private TreeNode<E> leftChild;
	private TreeNode<E> rightChild;
	private TreeNode<E> parent;
	private E element;
	
	public TreeNode(TreeNode<E> parent, E data)
	{
		this.parent=parent;
		element=data;
	}
	
	public TreeNode<E> getLeftChild()
	{
		return leftChild;
	}
	
	public TreeNode<E> getRightChild()
	{
		return rightChild;
	}
	
	public TreeNode<E> getParent()
	{
		return parent;
	}
	
	public E getElement()
	{
		return element;
	}
	
	public void setLeftChild(TreeNode<E> newChild)
	{
		if(newChild!=null)
		{
			newChild.setParent(this);
		}
		leftChild=newChild;
	}
	
	public void setRightChild(TreeNode<E> newChild)
	{
		if(rightChild!=null)
		{
			newChild.setParent(this);
		}
		rightChild=newChild;
	}
	
	public void setParent(TreeNode<E> newParent)
	{
		parent=newParent;
	}
	
	public void setElement(E data)
	{
		element=data;
	}
	
	public TreeNode<E> find(Integer object)
	{
		if(element==object)
		{
			return this;
		}
		else 
		{
			TreeNode<E> result;
			if(leftChild!=null)
			{
				result=leftChild.find(object);
				
				if(result!=null)
				{
					return result;
				}
			}
			
			if(rightChild!=null)
			{
				result=rightChild.find(object);
				
				if(result!=null)
				{
					return result;
				}
			}
			
			return null;
		}
	}
	
	public void print(int depth)
	{
		String parentHash;
		if(parent==null)
		{
			parentHash="0";
		}
		else
		{
			parentHash=parent.getElement().toString();
		}
		System.out.println("Depth "+depth+": Parent "+parentHash+": "+element.toString());
		if(leftChild!=null)
		{
			leftChild.print(depth+1);
		}
		
		if(rightChild!=null)
		{
			rightChild.print(depth+1);
		}
	}
}
