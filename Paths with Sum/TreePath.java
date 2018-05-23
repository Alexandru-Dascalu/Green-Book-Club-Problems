import java.util.LinkedList;

public class TreePath
{
	private LinkedList<TreeNode<Integer>> path;
	private int sum;
	
	public TreePath(TreePath original)
	{
		path=(LinkedList<TreeNode<Integer>>)original.getPath().clone();
		sum=original.getSum();
	}
	
	public TreePath()
	{
		path=new LinkedList<>();
		sum=0;
	}
	
	public LinkedList<TreeNode<Integer>> getPath()
	{
		return path;
	}
	
	public void setPath(LinkedList<TreeNode<Integer>> newPath)
	{
		path=newPath;
	}
	
	public int getSum()
	{
		return sum;
	}
	
	public void add(TreeNode<Integer> node)
	{
		path.add(node);
		sum+=node.getElement().intValue();
	}
	
	@Override
	public String toString()
	{
		String pathString="<";
		
		for(TreeNode<Integer> node: path)
		{
			pathString+=node.getElement().toString()+", ";
		}
		
		pathString+=">";
		
		return pathString;
	}
}
