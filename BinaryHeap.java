public class BinaryHeap
{
	int[] array ;
	int size;
	public BinaryHeap()
	{
		array = new int[10];
		size = 0;
	}
	public void add(int item)
	{
		if(size == array.length)
		{
			growArray();
		}
		array[size++]= item;
		int child = size-1;
		int parent = (child-1)/2;
		if(parent>=0)
		{
		while(array[parent] > array[child])
		{
			swap(array, parent, child);
			child = parent;
			parent = (child-1)/2;
		}
	}

	}
	public void swap(int[] array, int parent, int child)
	{
		int temp=array[parent];
		array[parent]=array[child];
		array[child]=temp;
	}

	public int remove() 
	{
		if(size==0)
		{
			return -1;
		}
//always remove root
		int root = array[0];
		array[0]= array[--size];
		siftDown(0);
		return root;
	}

	public void siftDown(int pos)
	{
		int child = pos *2 +1;
		if(child>= size)
		{
			return;
		}
		if(child+1<size && array[child+1]< array[child])
		{
			child=child+1;
		}
		if(array[pos]>array[child])
		{
			swap(array, child, pos);
			siftDown(child);
		}

	}

	public void growArray()
	{
		int[]tempArray = new int[array.length*2];
		int size = array.length;
		for (int i=0; i<size; i++)
		{
			tempArray[i] = array[i];
		}
	array = tempArray;
 	}
}