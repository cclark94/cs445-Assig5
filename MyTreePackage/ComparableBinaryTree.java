package MyTreePackage;
import java.util.*;

public class ComparableBinaryTree<T extends Comparable<? super T>>
			extends BinaryTree<T>
			implements ComparableTreeInterface<T>
{
	public T getMax()
	{
		// Iterate through the tree and keep track of the
		// maximum value encountered
		Iterator<T> iter = getInorderIterator();
		T max = iter.next();
		while (iter.hasNext())
		{
			T item = iter.next();
			if (item.compareTo(max) > 0)
				max = item;
		}
		return max;
	}
	
	public T getMin()
	{
		// Iterate through the tree and keep track of the
		// minimum value encountered
		Iterator<T> iter = getInorderIterator();
		T min = iter.next();
		while (iter.hasNext())
		{
			T item = iter.next();
			if (item.compareTo(min) < 0)
				min = item;
		}
		return min;
	}
	
	public boolean isBST()
	{
		// Compare adjacent values from an inorder
		// iterator. The next value in the iterator should
		// always be greater than the current value.
		Iterator<T> iter = getInorderIterator();
		boolean isBST = true;
		T current = iter.next();
		while (iter.hasNext())
		{
			T next = iter.next();
			if (next.compareTo(current) < 0)
			{
				isBST = false;
				break;
			}
			current = next;
		}
		return isBST;
	}
}
